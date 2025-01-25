package com.example.desafio_itau.domain.Services;


import com.example.desafio_itau.ValidacaoException;
import com.example.desafio_itau.domain.Dto.TransacaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private List<TransacaoDTO> transacoes = new ArrayList<>();

    public void adicionaTransacao(TransacaoDTO transacaoDTO) {
        OffsetDateTime dataLocal = OffsetDateTime.now();

        if (transacaoDTO.dataHora().isAfter(dataLocal)) {
            throw new ValidacaoException("Não é permitido data futura");
        }
        if (transacaoDTO.valor() < 0) {
            throw new ValidacaoException("Não é permitido valor menor que 0");
        }

        transacoes.add(transacaoDTO);
    }


    public List<TransacaoDTO> getAllTransacoes() {

        return transacoes;
    }


    public void deleteAllTransacoes() {

        transacoes.clear();

    }
}
