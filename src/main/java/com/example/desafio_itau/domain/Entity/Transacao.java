package com.example.desafio_itau.domain.Entity;


import com.example.desafio_itau.domain.Dto.TransacaoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Transacao {


    double valor;

    OffsetDateTime dataHora;

    public Transacao(TransacaoDTO transacaoDTO) {
        this.valor = transacaoDTO.valor();
        this.dataHora = transacaoDTO.dataHora();
    }
}
