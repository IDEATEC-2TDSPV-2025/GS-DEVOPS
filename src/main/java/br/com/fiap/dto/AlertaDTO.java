package br.com.fiap.dto;

import br.com.fiap.model.enums.StatusAlerta;
import br.com.fiap.model.enums.TipoAlerta;
import java.time.LocalDateTime;

public record AlertaDTO(
        Long id,
        Long zonaDeRiscoId,
        StatusAlerta status,
        TipoAlerta tipoAlerta,
        String mensagem,
        LocalDateTime dataHora
) {}
