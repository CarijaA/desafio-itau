package com.example.desafio_itau.Controller;

import com.example.desafio_itau.ValidacaoException;
import com.example.desafio_itau.domain.Dto.TransacaoDTO;
import com.example.desafio_itau.domain.Services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity addTransacao(@Valid @RequestBody TransacaoDTO transacaoDTO) {

        try {

            transacaoService.adicionaTransacao(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Transação cadastrada com sucesso!");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity getTransacoes() {

        return ResponseEntity.ok(transacaoService.getAllTransacoes());

    }

    @DeleteMapping
    public ResponseEntity deleteTransacoes(
    ) {
        transacaoService.deleteAllTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
