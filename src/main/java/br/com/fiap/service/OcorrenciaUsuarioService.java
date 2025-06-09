package br.com.fiap.service;

import br.com.fiap.dto.OcorrenciaUsuarioDTO;
import br.com.fiap.model.OcorrenciaUsuario;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.OcorrenciaUsuarioRepository;
import br.com.fiap.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaUsuarioService {

    @Autowired
    private OcorrenciaUsuarioRepository ocorrenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public OcorrenciaUsuarioDTO reportarOcorrencia(OcorrenciaUsuarioDTO dto) {
        OcorrenciaUsuario ocorrencia = new OcorrenciaUsuario();
        ocorrencia.setDescricao(dto.descricao());
        ocorrencia.setFotoUrl(dto.fotoUrl());
        ocorrencia.setLatitude(dto.latitude());
        ocorrencia.setLongitude(dto.longitude());
        ocorrencia.setStatus(dto.status());
        ocorrencia.setDataHora(dto.dataHora());
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        ocorrencia.setUsuario(usuario);
        return convertToDTO(ocorrenciaRepository.save(ocorrencia));
    }

    public Page<OcorrenciaUsuarioDTO> listarPorUsuario(Long usuarioId, Pageable pageable) {
        return ocorrenciaRepository.findByUsuarioId(usuarioId, pageable)
                .map(this::convertToDTO);
    }

    private OcorrenciaUsuarioDTO convertToDTO(OcorrenciaUsuario ocorrencia) {
        return new OcorrenciaUsuarioDTO(
                ocorrencia.getId(),
                ocorrencia.getUsuario().getId(),
                ocorrencia.getDescricao(),
                ocorrencia.getFotoUrl(),
                ocorrencia.getLatitude(),
                ocorrencia.getLongitude(),
                ocorrencia.getStatus(),
                ocorrencia.getDataHora()
        );
    }
}
