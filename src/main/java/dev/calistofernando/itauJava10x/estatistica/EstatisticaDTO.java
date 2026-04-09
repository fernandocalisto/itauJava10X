package dev.calistofernando.itauJava10x.estatistica;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor

public class EstatisticaDTO {

    private final Long count;
    private final BigDecimal sum;
    private final BigDecimal avg;
    private final BigDecimal min;
    private final BigDecimal max;

}
