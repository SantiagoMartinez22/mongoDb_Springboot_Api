package com.apiMongo.tadb4.Services;




import com.apiMongo.tadb4.Exception.ResourceNotFoundException;
import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import com.apiMongo.tadb4.Models.Medicamento;
import com.apiMongo.tadb4.Repository.MedicamentoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicamentoService {
    private final MedicamentoRepository repository;
    private final CompuestoMedicamentoService compuestoMedicamentoService;

    public MedicamentoService(
            MedicamentoRepository repository,
            CompuestoMedicamentoService compuestoMedicamentoService
    ) {
        this.repository = repository;
        this.compuestoMedicamentoService = compuestoMedicamentoService;
    }

    public List<Medicamento> getAll() {
        return repository.findAll();
    }

    public Medicamento getById(String id) {
        return repository.findById(new ObjectId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));
    }

    public Medicamento create(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public Medicamento update(String id, Medicamento medicamento) {
        ObjectId objectId = new ObjectId(id);
        return repository.findById(objectId)
                .map(existing -> {
                    medicamento.setId(objectId);
                    return repository.save(medicamento);
                }).orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));
    }

    public void delete(String id) {
        repository.deleteById(new ObjectId(id));
    }

    public List<CompuestoMedicamento> getCompuestosByMedicamentoId(String medicamentoId) {
        return compuestoMedicamentoService.getByMedicamentoId(medicamentoId);
    }
}
