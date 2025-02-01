package br.com.devdojo.tk.tokiomarine.validation;

import br.com.devdojo.tk.tokiomarine.exception.TaxaNaoAplicavelException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.NavigableMap;
import java.util.TreeMap;

@Component
public class TaxaCalculadora {

    // Regras de taxa: Mapeamento entre o número mínimo de dias e a regra correspondente
    private final NavigableMap<Long, RegraTaxa> regrasTaxa = new TreeMap<>();

    public TaxaCalculadora() {
        // Inicializando as regras de taxa conforme a tabela
        regrasTaxa.put(0L, new RegraTaxa(new BigDecimal("3.00"), new BigDecimal("0.025"))); // 0 dias
        regrasTaxa.put(1L, new RegraTaxa(new BigDecimal("12.00"), BigDecimal.ZERO));        // 1-10 dias
        regrasTaxa.put(11L, new RegraTaxa(BigDecimal.ZERO, new BigDecimal("0.082")));       // 11-20 dias
        regrasTaxa.put(21L, new RegraTaxa(BigDecimal.ZERO, new BigDecimal("0.069")));       // 21-30 dias
        regrasTaxa.put(31L, new RegraTaxa(BigDecimal.ZERO, new BigDecimal("0.047")));       // 31-40 dias
        regrasTaxa.put(41L, new RegraTaxa(BigDecimal.ZERO, new BigDecimal("0.017")));       // 41-50 dias
    }

    /**
     * Calcula a taxa com base no valor e na diferença de dias
     *
     * @param valor      Valor da transferência
     * @param diasDiferenca Diferença de dias entre a data de agendamento e a data de transferência
     * @return Taxa calculada (soma da taxa fixa e percentual)
     * @throws TaxaNaoAplicavelException Se a diferença de dias não for aplicável
     */
    public BigDecimal calcularTaxa(BigDecimal valor, long diasDiferenca) {
        // Verifica se a diferença de dias está dentro dos limites
        if (diasDiferenca < 0 || diasDiferenca > 50) {
            throw new TaxaNaoAplicavelException("Período inválido: Não há taxa aplicável para a diferença de " + diasDiferenca + " dias.");
        }

        // Identifica a regra aplicável com base na diferença de dias
        RegraTaxa regra = regrasTaxa.floorEntry(diasDiferenca).getValue();

        // Calcula a taxa total: Taxa fixa + (Valor * Taxa percentual)
        return regra.taxaFixa().add(valor.multiply(regra.taxaPercentual()));
    }

    /**
     * Representa uma regra de taxa composta por uma taxa fixa e uma taxa percentual
     */
    private record RegraTaxa(BigDecimal taxaFixa, BigDecimal taxaPercentual) {}
}
