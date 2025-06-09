package br.com.fiap.repository;

import br.com.fiap.model.HistoricoManutencaoSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoManutencaoSensorRepository extends JpaRepository<HistoricoManutencaoSensor, Long> {
    List<HistoricoManutencaoSensor> findBySensorId(Long sensorId);
}
