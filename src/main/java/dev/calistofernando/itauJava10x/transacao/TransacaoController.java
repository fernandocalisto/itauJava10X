package dev.calistofernando.itauJava10x.transacao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
@Slf4j

public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    @PostMapping("/adicionar")
    public ResponseEntity adicionar(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {

        try {
            transacaoService.validarTransacao(transacaoRequestDTO);
            transacaoRepository.salvar(transacaoRequestDTO);
            log.info("Tudo certo chefe! ");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            log.error("Erro em uma ou mais validações, tente novamente: ", e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            log.error("Erro ao adicionar transação: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/deletar")
    public ResponseEntity deletar(){
        transacaoRepository.deletar();
        return ResponseEntity.ok().build();
    }

}
