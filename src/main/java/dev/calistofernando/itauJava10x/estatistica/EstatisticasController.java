package dev.calistofernando.itauJava10x.estatistica;

import dev.calistofernando.itauJava10x.transacao.TransacaoRepository;
import dev.calistofernando.itauJava10x.transacao.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.Comparator;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
@Slf4j

public class EstatisticasController {

    private final TransacaoRepository transacaoRepository;
    private final EstatisticasProperties estatisticasProperties;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> Estatisticas () {

        log.info("Calculando estatísticas de transações nos últimos " + estatisticasProperties.segundos() + "segundos.");

        final var horaAtual = OffsetDateTime.now()
                .minusSeconds(estatisticasProperties.segundos());

        EstatisticaDTO estatisticaDTO = transacaoRepository.estatistica(horaAtual);

        return  ResponseEntity.ok(estatisticaDTO);
    }

}
