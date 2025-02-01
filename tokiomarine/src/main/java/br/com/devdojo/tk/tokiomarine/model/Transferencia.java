package br.com.devdojo.tk.tokiomarine.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Conta de origem é obrigatória")
    @Pattern(regexp = "^\\d{10}$", message = "Conta deve ter exatamente 10 dígitos")
    @Column(nullable = false, length = 10)
    private String contaOrigem;

    @NotBlank(message = "Conta de destino é obrigatória")
    @Pattern(regexp = "^\\d{10}$", message = "Conta deve ter exatamente 10 dígitos")
    @Column(nullable = false, length = 10)
    private String contaDestino;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor mínimo é R$ 0,01")
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal valor;

    @NotNull(message = "Taxa é obrigatória")
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal taxa;

    @FutureOrPresent(message = "Data de transferência deve ser hoje ou no futuro")
    @Column(nullable = false)
    private LocalDate dataTransferencia;

    @Column(nullable = false, updatable = false)
    private LocalDate dataAgendamento;

    @PrePersist
    protected void onPersist() {
        this.dataAgendamento = LocalDate.now();
    }

}