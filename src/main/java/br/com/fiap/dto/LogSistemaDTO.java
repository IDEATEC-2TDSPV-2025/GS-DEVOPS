package br.com.fiap.dto;

import java.time.LocalDateTime;

public record LogSistemaDTO(
        Long id,
        Long usuarioId,
        String acao,
        String descricao,
        LocalDateTime dataHora
) {}
