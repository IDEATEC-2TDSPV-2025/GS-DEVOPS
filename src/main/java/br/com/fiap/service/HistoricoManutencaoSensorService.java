package br.com.fiap.service;

import br.com.fiap.dto.HistoricoManutencaoSensorDTO;
import br.com.fiap.model.HistoricoManutencaoSensor;
import br.com.fiap.model.Sensor;
import br.com.fiap.repository.HistoricoManutencaoSensorRepository;
import br.com.fiap.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoManutencaoSensorService {

    @Autowired
    private HistoricoManutencaoSensorRepository historicoRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public HistoricoManutencaoSensorDTO registrarManutencao(HistoricoManutencaoSensorDTO dto) {
        HistoricoManutencaoSensor manutencao = new HistoricoManutencaoSensor();
        manutencao.setDescricao(dto.descricao());
        manutencao.setDataManutencao(dto.dataManutencao());
        manutencao.setRealizadoPor(dto.realizadoPor());
        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));
        manutencao.setSensor(sensor);
        return convertToDTO(historicoRepository.save(manutencao));
    }

    public List<HistoricoManutencaoSensorDTO> listarPorSensor(Long sensorId) {
        return historicoRepository.findBySensorId(sensorId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private HistoricoManutencaoSensorDTO convertToDTO(HistoricoManutencaoSensor manutencao) {
        return new HistoricoManutencaoSensorDTO(
                manutencao.getId(),
                manutencao.getSensor().getId(),
                manutencao.getDescricao(),
                manutencao.getDataManutencao(),
                manutencao.getRealizadoPor()
        );
    }
}
