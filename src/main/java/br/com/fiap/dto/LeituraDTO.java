package br.com.fiap.dto;

import java.time.LocalDateTime;

public record LeituraDTO(
        Long id,
        Long sensorId,
        Double nivelAguaCm,
        LocalDateTime dataHora
) {}
