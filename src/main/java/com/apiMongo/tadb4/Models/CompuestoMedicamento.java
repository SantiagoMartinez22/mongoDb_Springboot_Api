package com.apiMongo.tadb4.Models;



import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Document(collection = "compuestos_medicamento")
@Data
public class CompuestoMedicamento {
    @Id
    private ObjectId id;

    @NotNull(message = "ID de compuesto requerido")
    private ObjectId compuestoId;

    @NotNull(message = "ID de medicamento requerido")
    private ObjectId medicamentoId;

    @NotNull(message = "La concentración es obligatoria")
    private Double concentracion;

    @NotBlank(message = "La unidad de medida es obligatoria")
    private String unidadMedida;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public String getCompuestoId() {
        return compuestoId.toHexString();
    }

    public String getMedicamentoId() {
        return medicamentoId.toHexString();
    }
}
