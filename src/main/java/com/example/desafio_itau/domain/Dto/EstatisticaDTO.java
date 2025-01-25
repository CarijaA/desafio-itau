package com.example.desafio_itau.domain.Dto;

import jakarta.validation.constraints.NotNull;

public record EstatisticaDTO(@NotNull double count, @NotNull double avg, @NotNull double min, @NotNull double max, @NotNull double sum) {
}
