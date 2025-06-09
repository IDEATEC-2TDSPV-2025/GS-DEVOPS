package br.com.fiap.repository;

import br.com.fiap.model.OcorrenciaUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaUsuarioRepository extends JpaRepository<OcorrenciaUsuario, Long> {
    Page<OcorrenciaUsuario> findByUsuarioId(Long usuarioId, Pageable pageable); // Assinatura correta
}
