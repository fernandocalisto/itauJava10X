package dev.calistofernando.itauJava10x.transacao;

import dev.calistofernando.itauJava10x.estatistica.EstatisticaDTO;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
@Data

public class TransacaoRepository {

    List<TransacaoRequestDTO> listaDeTransacoes = new ArrayList<>();

    public void salvar(TransacaoRequestDTO transacaoRequestDTO){
        listaDeTransacoes.add(transacaoRequestDTO);

    }

    public void deletar(){
        listaDeTransacoes.clear();
    }

    public void limpar(){

    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial) {
        if (listaDeTransacoes.isEmpty()){
            EstatisticaDTO estatisticaDTO = new EstatisticaDTO(0L, BigDecimal.valueOf(0),BigDecimal.valueOf(0),BigDecimal.valueOf(0),BigDecimal.valueOf(0));
            return estatisticaDTO;
        }

        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(summary.getCount(),
                BigDecimal.valueOf(summary.getSum()),
                BigDecimal.valueOf(summary.getAverage()),
                BigDecimal.valueOf(summary.getMin()),
                BigDecimal.valueOf(summary.getMax()));
    }

}
