package dev.calistofernando.itauJava10x.transacao;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data

public class TransacaoRequestDTO {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

}
