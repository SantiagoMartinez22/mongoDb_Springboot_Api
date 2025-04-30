package com.apiMongo.tadb4.Repository;




import com.apiMongo.tadb4.Models.CompuestoMedicamento;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CompuestoMedicamentoRepository extends MongoRepository<CompuestoMedicamento, ObjectId> {
    List<CompuestoMedicamento> findByCompuestoId(ObjectId compuestoId);
    List<CompuestoMedicamento> findByMedicamentoId(ObjectId medicamentoId);
}