package com.apiMongo.tadb4.Repository;







import com.apiMongo.tadb4.Models.Compuesto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompuestoRepository extends MongoRepository<Compuesto, ObjectId> {
}
