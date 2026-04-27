package dev.calistofernando.itauJava10x;

import dev.calistofernando.itauJava10x.estatistica.EstatisticasProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EstatisticasProperties.class)
public class ItauJava10xApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauJava10xApplication.class, args);
	}

}
