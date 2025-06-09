package br.com.fiap.service;

import br.com.fiap.dto.AlertaDTO;
import br.com.fiap.model.Alerta;
import br.com.fiap.model.enums.StatusAlerta;
import br.com.fiap.repository.AlertaRepository;
import br.com.fiap.repository.ZonaDeRiscoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private ZonaDeRiscoRepository zonaDeRiscoRepository;

    // Método para gerar alerta
    public AlertaDTO gerarAlerta(AlertaDTO dto) {
        Alerta alerta = convertToEntity(dto);
        alerta = alertaRepository.save(alerta);
        return convertToDTO(alerta);
    }

    // Método para listar alertas ativos
    public Page<AlertaDTO> listarAlertasAtivos(Pageable pageable) {
        return alertaRepository.findByStatus(StatusAlerta.ATIVO, pageable)
                .map(this::convertToDTO);
    }

    // Método para enviar alerta
    public void enviarAlerta(Long id) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado"));
        // Lógica de envio (ex: integrar com serviço de notificação)
        alerta.setStatus(StatusAlerta.RESOLVIDO);
        alertaRepository.save(alerta);
    }

    private Alerta convertToEntity(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        alerta.setMensagem(dto.mensagem());
        alerta.setDataHora(dto.dataHora());
        alerta.setStatus(dto.status());
        alerta.setTipoAlerta(dto.tipoAlerta());

        if(dto.zonaDeRiscoId() != null) {
            alerta.setZonaDeRisco(zonaDeRiscoRepository.findById(dto.zonaDeRiscoId())
                    .orElseThrow(() -> new EntityNotFoundException("Zona de risco não encontrada")));
        }

        return alerta;
    }

    private AlertaDTO convertToDTO(Alerta alerta) {
        return new AlertaDTO(
                alerta.getId(),
                alerta.getZonaDeRisco() != null ? alerta.getZonaDeRisco().getId() : null,
                alerta.getStatus(),
                alerta.getTipoAlerta(),
                alerta.getMensagem(),
                alerta.getDataHora()
        );
    }
}
