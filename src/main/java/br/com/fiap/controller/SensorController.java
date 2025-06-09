package br.com.fiap.controller;

import br.com.fiap.dto.SensorDTO;
import br.com.fiap.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sensores")
@Tag(name = "Sensores", description = "Gerenciamento de sensores IoT")
public class SensorController {

    @Autowired
    private SensorService service;

    @PostMapping
    @Operation(summary = "Cadastrar novo sensor")
    public ResponseEntity<SensorDTO> cadastrar(@Valid @RequestBody SensorDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar sensor por ID")
    public ResponseEntity<SensorDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/por-zona/{zonaId}")
    @Operation(summary = "Listar sensores por zona de risco")
    public ResponseEntity<Page<SensorDTO>> listarPorZona(
            @PathVariable Long zonaId, Pageable pageable) {
        return ResponseEntity.ok(service.listarPorZona(zonaId, pageable));
    }
}
