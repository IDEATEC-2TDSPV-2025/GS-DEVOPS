package br.com.fiap.dto;

import java.time.LocalDateTime;

public record ZonaDeRiscoDTO(
        Long id,
        String nome,
        String descricao,
        Double latitude,
        Double longitude,
        Double nivelCriticoCm,
        LocalDateTime dataCriacao
) {}
