-- Tabla de Usuarios
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL, -- Tal cual la tenés en Java
    PRIMARY KEY (id)
);

-- Tabla de Tópicos
CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    nombre_curso VARCHAR(100) NOT NULL, -- JPA traduce nombreCurso a nombre_curso
    mensaje VARCHAR(500) NOT NULL,
    fecha DATETIME NOT NULL,
    activo TINYINT NOT NULL,
    PRIMARY KEY (id)
);