// Crear usuario para la API con permisos CRUD completos
db.getSiblingDB("medicamentos_db").createUser({
  user: "medicamentos_usr",
  pwd: "medicamentos123",
  roles: [
    {
      role: "readWrite",
      db: "medicamentos_db",
    },
  ],
});

db.getSiblingDB("medicamentos_db").createCollection("medicamentos", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre", "fabricante"],
      properties: {
        nombre: {
          bsonType: "string",
          description: "Nombre del medicamento - requerido",
        },
        fabricante: {
          bsonType: "string",
          description: "Fabricante del medicamento - requerido",
        },
      },
    },
  },
});

db.getSiblingDB("medicamentos_db").createCollection("compuestos", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre"],
      properties: {
        nombre: {
          bsonType: "string",
          description: "Nombre del compuesto químico - requerido",
        },
      },
    },
  },
});

db.getSiblingDB("medicamentos_db").createCollection("compuestos_medicamento", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "compuestoId",
        "medicamentoId",
        "concentracion",
        "unidadMedida",
      ],
      properties: {
        compuestoId: {
          bsonType: "objectId",
          description: "ID del compuesto - requerido",
        },
        medicamentoId: {
          bsonType: "objectId",
          description: "ID del medicamento - requerido",
        },
        concentracion: {
          bsonType: "double",
          minimum: 0,
          description:
            "Concentración del compuesto en el medicamento - requerido y debe ser positivo",
        },
        unidadMedida: {
          bsonType: "string",
          description: "Unidad de medida de la concentración - requerido",
        },
      },
    },
  },
});

db.getSiblingDB("medicamentos_db").medicamentos.createIndex(
  { nombre: 1 },
  { name: "nombre_medicamento_idx", unique: true }
);
db.getSiblingDB("medicamentos_db").compuestos.createIndex(
  { nombre: 1 },
  { name: "nombre_compuesto_idx", unique: true }
);
db.getSiblingDB("medicamentos_db").compuestos_medicamento.createIndex(
  { compuestoId: 1, medicamentoId: 1 },
  { name: "compuesto_medicamento_idx", unique: true }
);
db.getSiblingDB("medicamentos_db").compuestos_medicamento.createIndex(
  { medicamentoId: 1 },
  { name: "medicamento_idx" }
);
db.getSiblingDB("medicamentos_db").compuestos_medicamento.createIndex(
  { compuestoId: 1 },
  { name: "compuesto_idx" }
);

print(
  "Usuarios, colecciones e índices creados/actualizados en medicamentos_db."
);
