package br.com.fiap.repository;

import br.com.fiap.model.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Page<Sensor> findByZonaDeRiscoId(Long zonaId, Pageable pageable); // Corrigido
}
