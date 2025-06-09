package br.com.fiap.repository;

import br.com.fiap.model.LogSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogSistemaRepository extends JpaRepository<LogSistema, Long> {
}
