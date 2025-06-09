package br.com.fiap.repository;

import br.com.fiap.model.Leitura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraRepository extends JpaRepository<Leitura, Long> {
    Page<Leitura> findBySensorId(Long sensorId, Pageable pageable);
}
