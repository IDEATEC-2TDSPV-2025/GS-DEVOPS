package br.com.fiap.repository;

import br.com.fiap.model.ZonaDeRisco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaDeRiscoRepository extends JpaRepository<ZonaDeRisco, Long> {
    // Métodos customizados podem ser adicionados aqui, se necessário
}
