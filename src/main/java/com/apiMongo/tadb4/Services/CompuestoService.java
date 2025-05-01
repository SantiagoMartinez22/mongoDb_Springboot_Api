package com.apiMongo.tadb4.Services;


import com.apiMongo.tadb4.Exception.ResourceNotFoundException;
import com.apiMongo.tadb4.Models.Compuesto;
import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import com.apiMongo.tadb4.Repository.CompuestoRepository;
import com.apiMongo.tadb4.dto.CompuestoRequest;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompuestoService {
    private final CompuestoRepository repository;
    private final CompuestoMedicamentoService compuestoMedicamentoService;

    public CompuestoService(
            CompuestoRepository repository,
            CompuestoMedicamentoService compuestoMedicamentoService
    ) {
        this.repository = repository;
        this.compuestoMedicamentoService = compuestoMedicamentoService;
    }

    public List<Compuesto> getAllCompuestos() {
        return repository.findAll();
    }

    public Compuesto getCompuestoById(String id) {
        return repository.findById(new ObjectId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Compuesto no encontrado con ID: " + id));
    }

    public Compuesto createCompuesto(CompuestoRequest request) {
        Compuesto compuesto = new Compuesto();
        compuesto.setNombre(request.nombre());
        return repository.save(compuesto);
    }

    public Compuesto updateCompuesto(String id, CompuestoRequest request) {
        ObjectId objectId = new ObjectId(id);
        return repository.findById(objectId)
                .map(existing -> {
                    existing.setNombre(request.nombre());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Compuesto no encontrado con ID: " + id));
    }

    public void deleteCompuesto(String id) {
        ObjectId objectId = new ObjectId(id);
        if (!repository.existsById(objectId)) {
            throw new ResourceNotFoundException("Compuesto no encontrado con ID: " + id);
        }
        repository.deleteById(objectId);
    }

    public List<CompuestoMedicamento> getMedicamentosByCompuestoId(String compuestoId) {
        return compuestoMedicamentoService.getByCompuestoId(compuestoId);
    }
}