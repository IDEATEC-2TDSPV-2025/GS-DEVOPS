package br.com.fiap.controller;

import br.com.fiap.dto.OcorrenciaUsuarioDTO;
import br.com.fiap.service.OcorrenciaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaUsuarioController {

    @Autowired
    private OcorrenciaUsuarioService service;

    @PostMapping
    public ResponseEntity<OcorrenciaUsuarioDTO> reportarOcorrencia(
            @RequestBody OcorrenciaUsuarioDTO dto) {
        return ResponseEntity.status(201).body(service.reportarOcorrencia(dto));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Page<OcorrenciaUsuarioDTO>> listarPorUsuario(
            @PathVariable Long usuarioId, Pageable pageable) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId, pageable));
    }
}
