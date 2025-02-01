package br.com.devdojo.tk.tokiomarine.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record TransferenciaRequest(
        @NotBlank(message = "A conta de origem é obrigatória")
        @Pattern(regexp = "\\d{10}", message = "A conta de origem deve ter exatamente 10 dígitos")
        String contaOrigem,

        @NotBlank(message = "A conta de destino é obrigatória")
        @Pattern(regexp = "\\d{10}", message = "A conta de destino deve ter exatamente 10 dígitos")
        String contaDestino,

        @NotNull(message = "O valor da transferência é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor da transferência deve ser maior que zero")
        BigDecimal valor,

        @NotNull(message = "A data de transferência é obrigatória")
        @FutureOrPresent(message = "A data de transferência não pode estar no passado")
        LocalDate dataTransferencia
) {}
