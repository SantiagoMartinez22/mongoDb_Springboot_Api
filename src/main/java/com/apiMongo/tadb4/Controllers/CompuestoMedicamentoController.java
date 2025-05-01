package com.apiMongo.tadb4.Controllers;

import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import com.apiMongo.tadb4.Services.CompuestoMedicamentoService;
import com.apiMongo.tadb4.dto.CompuestoMedicamentoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/compuestos-medicamento")
public class CompuestoMedicamentoController {
    private final CompuestoMedicamentoService service;

    public CompuestoMedicamentoController(CompuestoMedicamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CompuestoMedicamento> crearRelacion(
            @Valid @RequestBody CompuestoMedicamentoRequest request
    ) {
        return new ResponseEntity<>(
                service.crearRelacion(request),
                HttpStatus.CREATED
        );
    }
}
