package com.apiMongo.tadb4.Models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Document(collection = "medicamentos")
@Data
public class Medicamento {
    @Id
    private ObjectId id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El fabricante es obligatorio")
    private String fabricante;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }
}