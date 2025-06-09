package br.com.fiap.dto;

import br.com.fiap.model.enums.StatusOcorrencia;

import java.time.LocalDateTime;

public record OcorrenciaUsuarioDTO(
        Long id,
        Long usuarioId,
        String descricao,
        String fotoUrl,
        Double latitude,
        Double longitude,
        StatusOcorrencia status,
        LocalDateTime dataHora
) {}
