package com.example.desafio_itau.domain.Dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransacaoDTO(@NotNull double valor, @NotNull OffsetDateTime dataHora) {
}
