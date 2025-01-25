package com.example.desafio_itau.domain.Services;


import com.example.desafio_itau.domain.Dto.EstatisticaDTO;
import com.example.desafio_itau.domain.Dto.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EstatiscaService {


    @Autowired
    private TransacaoService transacaoService;

    public EstatisticaDTO getEstatisticas(int seconds) {
        OffsetDateTime agora = OffsetDateTime.now();
        List<TransacaoDTO> transacoes = transacaoService.getAllTransacoes();

        System.out.println("Transações registradas: " + transacoes);

        List<TransacaoDTO> transacoesRecentes = transacoes.stream()
                .filter(transacao -> {
                    boolean isRecent = transacao.dataHora().isAfter(agora.minusSeconds(seconds));
                    System.out.println("Verificando transação: " + transacao + ", Recente: " + isRecent);
                    return isRecent;
                })
                .toList();

        System.out.println("Transações nos últimos 60 segundos: " + transacoesRecentes);

        if (transacoesRecentes.isEmpty()) {
            return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics statistics = transacoesRecentes.stream()
                .mapToDouble(TransacaoDTO::valor)
                .summaryStatistics();

        return new EstatisticaDTO(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getMin(),
                statistics.getMax(),
                statistics.getAverage()
        );
    }
}