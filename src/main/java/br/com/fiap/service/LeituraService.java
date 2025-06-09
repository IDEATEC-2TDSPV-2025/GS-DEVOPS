package br.com.fiap.service;

import br.com.fiap.dto.LeituraDTO;
import br.com.fiap.model.Leitura;
import br.com.fiap.model.Sensor;
import br.com.fiap.repository.LeituraRepository;
import br.com.fiap.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LeituraService {

    @Autowired
    private LeituraRepository leituraRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public LeituraDTO registrarLeitura(LeituraDTO dto) {
        Leitura leitura = new Leitura();
        leitura.setNivelAguaCm(dto.nivelAguaCm());
        leitura.setDataHora(dto.dataHora());
        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));
        leitura.setSensor(sensor);
        return convertToDTO(leituraRepository.save(leitura));
    }

    public Page<LeituraDTO> listarPorSensor(Long sensorId, Pageable pageable) {
        return leituraRepository.findBySensorId(sensorId, pageable)
                .map(this::convertToDTO);
    }

    private LeituraDTO convertToDTO(Leitura leitura) {
        return new LeituraDTO(
                leitura.getId(),
                leitura.getSensor().getId(),
                leitura.getNivelAguaCm(),
                leitura.getDataHora()
        );
    }
}
