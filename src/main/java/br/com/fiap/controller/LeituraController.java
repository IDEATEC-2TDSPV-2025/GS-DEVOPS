package br.com.fiap.controller;

import br.com.fiap.dto.LeituraDTO;
import br.com.fiap.service.LeituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leituras")
public class LeituraController {

    @Autowired
    private LeituraService service;

    @PostMapping
    public ResponseEntity<LeituraDTO> registrarLeitura(@RequestBody LeituraDTO dto) {
        return ResponseEntity.status(201).body(service.registrarLeitura(dto));
    }

    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<Page<LeituraDTO>> listarPorSensor(
            @PathVariable Long sensorId, Pageable pageable) {
        return ResponseEntity.ok(service.listarPorSensor(sensorId, pageable));
    }
}
