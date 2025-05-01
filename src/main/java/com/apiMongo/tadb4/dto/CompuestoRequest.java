package com.apiMongo.tadb4.dto;


import jakarta.validation.constraints.NotBlank;

public record CompuestoRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre
) {}