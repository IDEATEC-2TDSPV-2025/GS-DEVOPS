package br.com.fiap.controller;

import br.com.fiap.dto.HistoricoManutencaoSensorDTO;
import br.com.fiap.service.HistoricoManutencaoSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manutencoes-sensores")
public class HistoricoManutencaoSensorController {

    @Autowired
    private HistoricoManutencaoSensorService service;

    @PostMapping
    public ResponseEntity<HistoricoManutencaoSensorDTO> registrarManutencao(
            @RequestBody HistoricoManutencaoSensorDTO dto) {
        return ResponseEntity.status(201).body(service.registrarManutencao(dto));
    }

    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<?> listarPorSensor(@PathVariable Long sensorId) {
        return ResponseEntity.ok(service.listarPorSensor(sensorId));
    }
}
