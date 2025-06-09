package br.com.fiap.dto;

import br.com.fiap.model.enums.TipoUsuario;

import java.time.LocalDateTime;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String senha, // para cadastro; nunca retorne em responses!
        TipoUsuario tipoUsuario,
        LocalDateTime dataCriacao
) {}
