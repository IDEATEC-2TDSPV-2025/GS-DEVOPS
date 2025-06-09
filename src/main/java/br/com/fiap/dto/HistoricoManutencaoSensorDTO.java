package br.com.fiap.dto;

import java.time.LocalDateTime;

public record HistoricoManutencaoSensorDTO(
        Long id,
        Long sensorId,
        String descricao,
        LocalDateTime dataManutencao,
        String realizadoPor
) {}
