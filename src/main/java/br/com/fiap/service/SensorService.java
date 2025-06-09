package br.com.fiap.service;

import br.com.fiap.dto.SensorDTO;
import br.com.fiap.model.Sensor;
import br.com.fiap.model.ZonaDeRisco;
import br.com.fiap.repository.SensorRepository;
import br.com.fiap.repository.ZonaDeRiscoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ZonaDeRiscoRepository zonaDeRiscoRepository;

    public SensorDTO salvar(SensorDTO dto) {
        Sensor sensor = convertToEntity(dto);
        sensor = sensorRepository.save(sensor);
        return convertToDTO(sensor);
    }

    public SensorDTO buscarPorId(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));
        return convertToDTO(sensor);
    }

    public Page<SensorDTO> listarPorZona(Long zonaId, Pageable pageable) {
        return sensorRepository.findByZonaDeRiscoId(zonaId, pageable)
                .map(this::convertToDTO);
    }

    private Sensor convertToEntity(SensorDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setCodigoIdentificador(dto.codigoIdentificador());
        sensor.setLocalizacaoDetalhada(dto.localizacaoDetalhada());
        sensor.setLatitude(dto.latitude());
        sensor.setLongitude(dto.longitude());
        sensor.setStatusOperacional(dto.statusOperacional());
        if (dto.zonaDeRiscoId() != null) {
            ZonaDeRisco zona = zonaDeRiscoRepository.findById(dto.zonaDeRiscoId())
                    .orElseThrow(() -> new EntityNotFoundException("Zona de risco não encontrada"));
            sensor.setZonaDeRisco(zona);
        }
        return sensor;
    }

    private SensorDTO convertToDTO(Sensor sensor) {
        return new SensorDTO(
                sensor.getId(),
                sensor.getCodigoIdentificador(),
                sensor.getLocalizacaoDetalhada(),
                sensor.getLatitude(),
                sensor.getLongitude(),
                sensor.getZonaDeRisco() != null ? sensor.getZonaDeRisco().getId() : null,
                sensor.getStatusOperacional(),
                sensor.getDataInstalacao()
        );
    }
}
