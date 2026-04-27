package dev.calistofernando.itauJava10x.estatistica;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(Integer segundos){
}
