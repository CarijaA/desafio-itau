package com.example.desafio_itau.domain.Entity;


import com.example.desafio_itau.domain.Dto.EstatisticaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Estatistica {


    double count;    // de transações nos últimos 60 segundos	Sim
    double sum;      //Soma total do valor transacionado nos últimos 60 segundos	Sim
    double avg;    //Média do valor transacionado nos últimos 60 segundos	Sim
    double min;    //Menor valor transacionado nos últimos 60 segundos	Sim
    double max;


    public Estatistica(EstatisticaDTO estatisticaDTO) {
        this.count = estatisticaDTO.count();
        this.sum = estatisticaDTO.sum();
        this.avg = estatisticaDTO.avg();
        this.min = estatisticaDTO.min();
        this.max = estatisticaDTO.max();
    }
}
