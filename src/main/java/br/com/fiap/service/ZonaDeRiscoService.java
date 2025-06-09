package br.com.fiap.service;

import br.com.fiap.dto.ZonaDeRiscoDTO;
import br.com.fiap.model.ZonaDeRisco;
import br.com.fiap.repository.ZonaDeRiscoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ZonaDeRiscoService {

    @Autowired
    private ZonaDeRiscoRepository zonaDeRiscoRepository;

    public ZonaDeRiscoDTO salvar(ZonaDeRiscoDTO dto) {
        ZonaDeRisco zona = convertToEntity(dto);
        zona = zonaDeRiscoRepository.save(zona);
        return convertToDTO(zona);
    }

    public ZonaDeRiscoDTO buscarPorId(Long id) {
        ZonaDeRisco zona = zonaDeRiscoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zona de risco não encontrada"));
        return convertToDTO(zona);
    }

    public Page<ZonaDeRiscoDTO> listarTodos(Pageable pageable) {
        return zonaDeRiscoRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public ZonaDeRiscoDTO atualizar(Long id, ZonaDeRiscoDTO dto) {
        ZonaDeRisco zona = zonaDeRiscoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zona de risco não encontrada"));
        zona.setNome(dto.nome());
        zona.setDescricao(dto.descricao());
        zona.setLatitude(dto.latitude());
        zona.setLongitude(dto.longitude());
        zona.setNivelCriticoCm(dto.nivelCriticoCm());
        return convertToDTO(zonaDeRiscoRepository.save(zona));
    }

    public void excluir(Long id) {
        zonaDeRiscoRepository.deleteById(id);
    }

    private ZonaDeRisco convertToEntity(ZonaDeRiscoDTO dto) {
        ZonaDeRisco zona = new ZonaDeRisco();
        zona.setNome(dto.nome());
        zona.setDescricao(dto.descricao());
        zona.setLatitude(dto.latitude());
        zona.setLongitude(dto.longitude());
        zona.setNivelCriticoCm(dto.nivelCriticoCm());
        zona.setDataCriacao(dto.dataCriacao());
        return zona;
    }

    private ZonaDeRiscoDTO convertToDTO(ZonaDeRisco zona) {
        return new ZonaDeRiscoDTO(
                zona.getId(),
                zona.getNome(),
                zona.getDescricao(),
                zona.getLatitude(),
                zona.getLongitude(),
                zona.getNivelCriticoCm(),
                zona.getDataCriacao()
        );
    }
}
