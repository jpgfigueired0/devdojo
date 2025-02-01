package br.com.devdojo.tk.tokiomarine.dto.response;


import br.com.devdojo.tk.tokiomarine.model.Transferencia;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record TransferenciaResponse(
        Long id,
        String contaOrigem,
        String contaDestino,
        BigDecimal valor,
        BigDecimal taxa,
        LocalDate dataTransferencia,
        LocalDate dataAgendamento
) {

    /**
     * Converte uma entidade Transferencia para TransferenciaResponse.
     *
     * @param transferencia Entidade Transferencia
     * @return DTO TransferenciaResponse
     */
    public static TransferenciaResponse from(Transferencia transferencia) {
        return TransferenciaResponse.builder()
                .id(transferencia.getId())
                .contaOrigem(transferencia.getContaOrigem())
                .contaDestino(transferencia.getContaDestino())
                .valor(transferencia.getValor())
                .taxa(transferencia.getTaxa())
                .dataTransferencia(transferencia.getDataTransferencia())
                .dataAgendamento(transferencia.getDataAgendamento())
                .build();
    }
}
