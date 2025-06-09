package br.com.fiap.repository;

import br.com.fiap.model.Alerta;
import br.com.fiap.model.enums.StatusAlerta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    Page<Alerta> findByStatus(StatusAlerta status, Pageable pageable);
}
