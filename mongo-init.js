// Crear usuario con permisos de lectura/escritura
db.getSiblingDB('medicamentos_db').createUser({
    user: "operador",
    pwd: "operador123",
    roles: [{
        role: "readWrite",
        db: "medicamentos_db"
    }]
});