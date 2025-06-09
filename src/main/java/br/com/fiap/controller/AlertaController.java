package br.com.fiap.controller;

import br.com.fiap.dto.AlertaDTO;
import br.com.fiap.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alertas")
@Tag(name = "Alertas", description = "Gestão de alertas de desastres")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @PostMapping
    @Operation(summary = "Gerar novo alerta")
    public ResponseEntity<AlertaDTO> gerarAlerta(@RequestBody AlertaDTO dto) {
        return ResponseEntity.status(201).body(service.gerarAlerta(dto));
    }

    @GetMapping("/ativos")
    @Operation(summary = "Listar alertas ativos")
    public ResponseEntity<Page<AlertaDTO>> listarAtivos(Pageable pageable) {
        return ResponseEntity.ok(service.listarAlertasAtivos(pageable));
    }

    @PostMapping("/{id}/enviar")
    @Operation(summary = "Enviar alerta pelos canais configurados")
    public ResponseEntity<Void> enviarAlerta(@PathVariable Long id) {
        service.enviarAlerta(id);
        return ResponseEntity.noContent().build();
    }
}
