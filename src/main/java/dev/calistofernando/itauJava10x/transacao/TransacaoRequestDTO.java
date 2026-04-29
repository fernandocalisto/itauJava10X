package dev.calistofernando.itauJava10x.transacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data

public class TransacaoRequestDTO {

    @NotNull(message = "O valor da transação é obrigatório: ")
    @Positive(message = "O valor da transação deve ser maior do que zero: ")
    private BigDecimal valor;
    @NotNull(message = "A data da transação é obrigatória: ")
    private OffsetDateTime dataHora;

}
