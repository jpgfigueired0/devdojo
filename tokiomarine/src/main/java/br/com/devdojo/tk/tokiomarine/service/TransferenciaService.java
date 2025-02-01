package br.com.devdojo.tk.tokiomarine.service;

import br.com.devdojo.tk.tokiomarine.dto.request.TransferenciaRequest;
import br.com.devdojo.tk.tokiomarine.dto.response.TransferenciaResponse;
import br.com.devdojo.tk.tokiomarine.exception.BusinessException;
import br.com.devdojo.tk.tokiomarine.exception.TaxaNaoAplicavelException;
import br.com.devdojo.tk.tokiomarine.model.Transferencia;
import br.com.devdojo.tk.tokiomarine.repository.TransferenciaRepository;
import br.com.devdojo.tk.tokiomarine.validation.TaxaCalculadora;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final TaxaCalculadora taxaCalculadora;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, TaxaCalculadora taxaCalculadora) {
        this.transferenciaRepository = transferenciaRepository;
        this.taxaCalculadora = taxaCalculadora;
    }

    @Transactional
    public TransferenciaResponse agendarTransferencia(TransferenciaRequest request) {
        validarDataTransferencia(request.dataTransferencia());

        long diasDiferenca = calcularDiferencaDias(request.dataTransferencia());
        BigDecimal taxa = calcularTaxaSegura(request.valor(), diasDiferenca);

        Transferencia transferencia = construirEntidade(request, taxa);
        Transferencia savedEntity = salvarTransferencia(transferencia);

        return TransferenciaResponse.from(savedEntity);
    }

    private void validarDataTransferencia(LocalDate dataTransferencia) {
        if (dataTransferencia.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de transferência não pode ser no passado");
        }
    }


    private long calcularDiferencaDias(LocalDate dataTransferencia) {
        return ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);
    }

    private BigDecimal calcularTaxaSegura(BigDecimal valor, long dias) {
        try {
            return taxaCalculadora.calcularTaxa(valor, dias);
        } catch (TaxaNaoAplicavelException ex) {
            throw new BusinessException("Não é possível agendar transferência para este período", "PERIODO_INVALIDO");
        }
    }

    private Transferencia construirEntidade(TransferenciaRequest request, BigDecimal taxa) {
        return Transferencia.builder()
                .contaOrigem(request.contaOrigem())
                .contaDestino(request.contaDestino())
                .valor(request.valor())
                .taxa(taxa)
                .dataTransferencia(request.dataTransferencia())
                .build();
    }

    private Transferencia salvarTransferencia(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }

    public List<TransferenciaResponse> listarTodasTransferencias() {
        return transferenciaRepository.findAll()
                .stream()
                .map(TransferenciaResponse::from)
                .toList();
    }

    public List<TransferenciaResponse> listarPorData(LocalDate dataTransferencia) {
        return transferenciaRepository.findByDataTransferencia(dataTransferencia)
                .stream()
                .map(TransferenciaResponse::from)
                .toList();
    }

    private void validarValorTransferencia(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que zero");
        }
    }

}