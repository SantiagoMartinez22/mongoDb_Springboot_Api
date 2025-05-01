package com.apiMongo.tadb4.Controllers;


import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import com.apiMongo.tadb4.Models.Medicamento;
import com.apiMongo.tadb4.Services.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {
    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/{id}/compuestos")
    public ResponseEntity<List<CompuestoMedicamento>> getCompuestos(@PathVariable String id) {
        return ResponseEntity.ok(service.getCompuestosByMedicamentoId(id));
    }

    @PostMapping
    public ResponseEntity<Medicamento> create(@RequestBody Medicamento medicamento) {
        return new ResponseEntity<>(service.create(medicamento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> update(@PathVariable String id, @RequestBody Medicamento medicamento) {
        return ResponseEntity.ok(service.update(id, medicamento));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
