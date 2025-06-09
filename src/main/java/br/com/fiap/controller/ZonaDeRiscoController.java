package br.com.fiap.controller;

import br.com.fiap.dto.ZonaDeRiscoDTO;
import br.com.fiap.service.ZonaDeRiscoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zonas-risco")
@Tag(name = "Zonas de Risco", description = "Gestão de áreas de risco monitoradas")
public class ZonaDeRiscoController {

    @Autowired
    private ZonaDeRiscoService service;

    @GetMapping
    @Operation(summary = "Listar todas as zonas de risco")
    public ResponseEntity<Page<ZonaDeRiscoDTO>> listarTodos(
            @PageableDefault(size = 10, sort = "dataCriacao") Pageable pageable) {
        return ResponseEntity.ok(service.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar zona de risco por ID")
    public ResponseEntity<ZonaDeRiscoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova zona de risco")
    public ResponseEntity<ZonaDeRiscoDTO> cadastrar(@RequestBody ZonaDeRiscoDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar zona de risco existente")
    public ResponseEntity<ZonaDeRiscoDTO> atualizar(
            @PathVariable Long id, @RequestBody ZonaDeRiscoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir zona de risco")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
