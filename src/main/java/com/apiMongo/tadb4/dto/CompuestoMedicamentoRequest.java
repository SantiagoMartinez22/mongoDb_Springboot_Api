package com.apiMongo.tadb4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CompuestoMedicamentoRequest(
        @NotBlank(message = "El ID del compuesto es obligatorio")
        String compuestoId,

        @NotBlank(message = "El ID del medicamento es obligatorio")
        String medicamentoId,

        @NotNull(message = "La concentración es obligatoria")
        @Positive(message = "La concentración debe ser un valor positivo")
        Double concentracion,

        @NotBlank(message = "La unidad de medida es obligatoria")
        String unidadMedida
) {}
