package dev.calistofernando.itauJava10x.Docs;

import dev.calistofernando.itauJava10x.transacao.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Transações",
    description = "Endingpoints de criação de transações")

public interface TransacaoControllerDoc {
    @Operation(summary = "Cria novas transações e adiciona em uma lista",
            description = "Recebe uma transação válida e adiciona em uma lista")

    @ApiResponse(responseCode = "201",
            description = "Transação criada com sucesso")

    @ApiResponse(responseCode = "422",
            description = "Erro de validação capturado")

    @ApiResponse(responseCode = "404",
            description = "Erro inesperado no servidor")
    public ResponseEntity adicionar(TransacaoRequestDTO transacaoRequestDTO);

    @Operation(summary = "Deleta as transações",
                description = "Apaga todas as transações criadas e listadas")
    @ApiResponse(responseCode = "200",
                description = "Transações deletadas com sucesso!")
    @ApiResponse(responseCode = "404",
                description = "Erro inesperado no servidor")
    public ResponseEntity deletar();
}
