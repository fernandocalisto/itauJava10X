package dev.calistofernando.itauJava10x;

import java.util.ArrayList;
import java.util.List;

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
