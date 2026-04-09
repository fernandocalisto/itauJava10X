package dev.calistofernando.itauJava10x.transacao;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

}
