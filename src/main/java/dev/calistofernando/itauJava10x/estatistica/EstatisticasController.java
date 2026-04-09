package dev.calistofernando.itauJava10x.estatistica;

import dev.calistofernando.itauJava10x.transacao.Transacao;
import dev.calistofernando.itauJava10x.transacao.TransacaoRepository;
import dev.calistofernando.itauJava10x.transacao.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor

public class EstatisticasController {

    private final TransacaoRepository transacaoRepository;
    private final EsatisticaProperties esatisticaProperties;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> getEstatisticas () {

        Long count = (long) transacaoRepository.getListaDeTransacoes().size();
        BigDecimal sum = transacaoRepository.getListaDeTransacoes().stream().map(TransacaoRequestDTO::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal avg = sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        BigDecimal max = transacaoRepository.getListaDeTransacoes().stream().map(TransacaoRequestDTO::getValor).max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO);
        BigDecimal min = transacaoRepository.getListaDeTransacoes().stream().map(TransacaoRequestDTO::getValor).min(Comparator.naturalOrder()).orElse(BigDecimal.ZERO);

        EstatisticaDTO estatisticaDTO = new EstatisticaDTO(count, sum, avg, min, max);

        return  ResponseEntity.ok(estatisticaDTO);
    }

}
