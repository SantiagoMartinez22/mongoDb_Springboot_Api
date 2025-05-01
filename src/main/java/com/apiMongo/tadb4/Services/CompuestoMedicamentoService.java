package com.apiMongo.tadb4.Services;


import com.apiMongo.tadb4.Exception.InvalidIdException;
import com.apiMongo.tadb4.Exception.ResourceNotFoundException;
import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import com.apiMongo.tadb4.Repository.CompuestoMedicamentoRepository;
import com.apiMongo.tadb4.Repository.CompuestoRepository;
import com.apiMongo.tadb4.Repository.MedicamentoRepository;
import com.apiMongo.tadb4.dto.CompuestoMedicamentoRequest;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CompuestoMedicamentoService {
    private final CompuestoMedicamentoRepository repository;
    private final CompuestoRepository compuestoRepository;
    private final MedicamentoRepository medicamentoRepository;

    public CompuestoMedicamentoService(
            CompuestoMedicamentoRepository repository,
            CompuestoRepository compuestoRepository,
            MedicamentoRepository medicamentoRepository
    ) {
        this.repository = repository;
        this.compuestoRepository = compuestoRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    @Transactional
    public CompuestoMedicamento crearRelacion(CompuestoMedicamentoRequest request) {
        // Validar formato de IDs
        ObjectId compuestoId = validarYConvertirId(request.compuestoId());
        ObjectId medicamentoId = validarYConvertirId(request.medicamentoId());

        // Verificar existencia de las entidades
        compuestoRepository.findById(compuestoId)
                .orElseThrow(() -> new ResourceNotFoundException("Compuesto no encontrado"));

        medicamentoRepository.findById(medicamentoId)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));

        // Crear y guardar la relación
        CompuestoMedicamento relacion = new CompuestoMedicamento();
        relacion.setCompuestoId(compuestoId);
        relacion.setMedicamentoId(medicamentoId);
        relacion.setConcentracion(request.concentracion());
        relacion.setUnidadMedida(request.unidadMedida());

        return repository.save(relacion);
    }
    private ObjectId validarYConvertirId(String id) {
        try {
            return new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidIdException("ID con formato inválido: " + id);
        }
    }

    public List<CompuestoMedicamento> getByCompuestoId(String compuestoId) {
        return repository.findByCompuestoId(new ObjectId(compuestoId));
    }

    public List<CompuestoMedicamento> getByMedicamentoId(String medicamentoId) {
        return repository.findByMedicamentoId(new ObjectId(medicamentoId));
    }
}
