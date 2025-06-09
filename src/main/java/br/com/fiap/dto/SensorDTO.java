package br.com.fiap.dto;

import br.com.fiap.model.enums.StatusOperacional;
import java.time.LocalDateTime;

public record SensorDTO(
        Long id,
        String codigoIdentificador,
        String localizacaoDetalhada,
        Double latitude,
        Double longitude,
        Long zonaDeRiscoId,
        StatusOperacional statusOperacional,
        LocalDateTime dataInstalacao
) {}
