package dev.calistofernando.itauJava10x.transacao;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service

public class TransacaoService {

    public void validarTransacao (TransacaoRequestDTO transacaoRequestDTO) {

        if (transacaoRequestDTO.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: Transações devem ter valor maior do que zero.");
        }

        if (transacaoRequestDTO.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: Data e hora inválidas.");
        }

        if (transacaoRequestDTO.getValor() == null) {
            throw new IllegalArgumentException("Erro: Transações devem conter algum valor.");
        }

        if (transacaoRequestDTO.getDataHora() == null) {
            throw new IllegalArgumentException("Erro: Transações devem conter a data e hora.");
        }

    }

}
