//package br.com.devdojo.tk.tokiomarine.validation;
//
//
//import br.com.devdojo.tk.tokiomarine.exception.TaxaNaoAplicavelException;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TaxaCalculadoraTest {
//
//    private final TaxaCalculadora taxaCalculadora = new TaxaCalculadora();
//
//    @Test
//    void deveCalcularTaxaParaMesmoDia() {
//        BigDecimal taxa = taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 0L);
//        assertEquals(new BigDecimal("28.00"), taxa); // R$ 3,00 + 2,5% de R$ 1000
//    }
//
//    @Test
//    void deveCalcularTaxaPara1A10Dias() {
//        BigDecimal taxa = taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 5L);
//        assertEquals(new BigDecimal("12.00"), taxa); // Apenas taxa fixa de R$ 12,00
//    }
//
//    @Test
//    void deveCalcularTaxaPara11A20Dias() {
//        BigDecimal taxa = taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 15L);
//        assertEquals(new BigDecimal("82.00"), taxa); // 8,2% de R$ 1000
//    }
//
//    @Test
//    void deveCalcularTaxaPara21A30Dias() {
//        BigDecimal taxa = taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 25L);
//        assertEquals(new BigDecimal("69.00"), taxa); // 6,9% de R$ 1000
//    }
//
//    @Test
//    void deveCalcularTaxaPara31A40Dias() {
//        BigDecimal taxa = taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 35L);
//        assertEquals(new BigDecimal("47.00"), taxa); // 4,7% de R$ 1000
//    }
//
//    @Test
//    void deveCalcularTaxaPara41A50Dias() {
//        BigDecimal taxa = taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 45L);
//        assertEquals(new BigDecimal("17.00"), taxa); // 1,7% de R$ 1000
//    }
//
//    @Test
//    void deveLancarExcecaoParaDiasNegativos() {
//        assertThrows(TaxaNaoAplicavelException.class, () -> taxaCalculadora.calcularTaxa(new BigDecimal("1000"), -1L));
//    }
//
//    @Test
//    void deveLancarExcecaoParaDiasAcimaDe50() {
//        assertThrows(TaxaNaoAplicavelException.class, () -> taxaCalculadora.calcularTaxa(new BigDecimal("1000"), 51L));
//    }
//}
