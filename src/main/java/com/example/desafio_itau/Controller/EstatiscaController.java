package com.example.desafio_itau.Controller;


import com.example.desafio_itau.domain.Dto.EstatisticaDTO;
import com.example.desafio_itau.domain.Dto.TransacaoDTO;
import com.example.desafio_itau.domain.Services.EstatiscaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatisca")
public class EstatiscaController {


    @Autowired
    EstatiscaService estatiscaService;

    @GetMapping("/{seconds}")
    public ResponseEntity<EstatisticaDTO> getEstatisticas(@PathVariable int seconds) {
        EstatisticaDTO estatisticas = estatiscaService.getEstatisticas(seconds);
        return ResponseEntity.ok(estatisticas);
    }
}