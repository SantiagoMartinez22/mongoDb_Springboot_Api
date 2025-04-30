package com.apiMongo.tadb4.Repository;




import com.apiMongo.tadb4.Models.Medicamento;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentoRepository extends MongoRepository<Medicamento, ObjectId> {
}

