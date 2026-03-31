package dev.calistofernando.itauJava10x;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class EstatisticaDTO {

    private final Long count;
    private final double avg;
    private final double max;
    private final double min;
    private final double sum;

}
