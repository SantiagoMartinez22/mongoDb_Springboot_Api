package com.apiMongo.tadb4.Controllers;


import com.apiMongo.tadb4.Models.Compuesto;
import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import com.apiMongo.tadb4.Services.CompuestoService;
import com.apiMongo.tadb4.dto.CompuestoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compuestos")
public class CompuestoController {
    private final CompuestoService service;

    public CompuestoController(CompuestoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Compuesto>> getAll() {
        return ResponseEntity.ok(service.getAllCompuestos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compuesto> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getCompuestoById(id));
    }

    @GetMapping("/{id}/medicamentos")
    public ResponseEntity<List<CompuestoMedicamento>> getMedicamentosByCompuesto(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(service.getMedicamentosByCompuestoId(id));
    }

    @PostMapping
    public ResponseEntity<Compuesto> create(@Valid @RequestBody CompuestoRequest request) {
        return new ResponseEntity<>(service.createCompuesto(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compuesto> update(
            @PathVariable String id,
            @Valid @RequestBody CompuestoRequest request
    ) {
        return ResponseEntity.ok(service.updateCompuesto(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteCompuesto(id);
    }
}