package br.com.fiap.service;

import br.com.fiap.dto.LogSistemaDTO;
import br.com.fiap.model.LogSistema;
import br.com.fiap.repository.LogSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LogSistemaService {

    @Autowired
    private LogSistemaRepository logRepository;

    public Page<LogSistemaDTO> listarLogs(Pageable pageable) {
        return logRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    private LogSistemaDTO convertToDTO(LogSistema log) {
        return new LogSistemaDTO(
                log.getId(),
                log.getUsuario() != null ? log.getUsuario().getId() : null,
                log.getAcao(),
                log.getDescricao(),
                log.getDataHora()
        );
    }
}
