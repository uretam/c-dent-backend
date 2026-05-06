CREATE DATABASE IF NOT EXISTS db_personas;
USE db_personas;

CREATE TABLE IF NOT EXISTS pacientes (
    id_paciente BIGINT AUTO_INCREMENT PRIMARY KEY,
    rut VARCHAR(255) NOT NULL UNIQUE,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    email VARCHAR(255),
    telefono VARCHAR(255),
    direccion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS contactos_emergencia (
    id_contacto BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_contacto VARCHAR(255) NOT NULL,
    telefono_contacto VARCHAR(255) NOT NULL,
    parentesco VARCHAR(255),
    id_paciente BIGINT NOT NULL,
    CONSTRAINT fk_contacto_paciente FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente)
);

CREATE TABLE IF NOT EXISTS odontologos (
    id_odontologo BIGINT AUTO_INCREMENT PRIMARY KEY,
    rut VARCHAR(255) NOT NULL UNIQUE,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    especialidad VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefono VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE
);

INSERT INTO pacientes (rut, nombres, apellidos, fecha_nacimiento, email, telefono, direccion, activo) VALUES 
('11111111-1', 'Juan', 'Pérez', '1990-05-15', 'juan.perez@email.com', '+56911111111', 'Av. Siempreviva 123', TRUE),
('22222222-2', 'María', 'Gómez', '1985-10-20', 'maria.gomez@email.com', '+56922222222', 'Pasaje Los Aromos 456', TRUE);

INSERT INTO contactos_emergencia (nombre_contacto, telefono_contacto, parentesco, id_paciente) VALUES
('Pedro Pérez', '+56900000001', 'Padre', 1),
('Ana Gómez', '+56900000002', 'Hermana', 2);

INSERT INTO odontologos (rut, nombres, apellidos, especialidad, email, telefono, activo) VALUES 
('33333333-3', 'Carlos', 'Tapia', 'Ortodoncia', 'dr.tapia@cdent.com', '+56933333333', TRUE),
('44444444-4', 'Ana', 'Ríos', 'Odontología General', 'dra.rios@cdent.com', '+56944444444', TRUE);

-- -------------------------------------------------------

CREATE DATABASE IF NOT EXISTS db_clinica;
USE db_clinica;

CREATE TABLE IF NOT EXISTS citas (
    id_cita BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_paciente BIGINT NOT NULL,
    id_odontologo BIGINT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    motivo VARCHAR(255),
    estado VARCHAR(255) DEFAULT 'AGENDADA'
);

INSERT INTO citas (id_paciente, id_odontologo, fecha_hora, motivo, estado) VALUES
(1, 1, '2026-06-15 10:00:00', 'Control de frenillos', 'AGENDADA'),
(2, 2, '2026-06-16 15:30:00', 'Limpieza general', 'AGENDADA');

-- -------------------------------------------------------

CREATE DATABASE IF NOT EXISTS db_administracion;
USE db_administracion;

CREATE TABLE IF NOT EXISTS insumos (
    id_insumo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    precio_unidad DECIMAL(10,2) NOT NULL
);

INSERT INTO insumos (nombre, cantidad, precio_unidad) VALUES
('Caja de Guantes de Látex', 50, 5500.00),
('Anestesia Local (Ampollas)', 100, 12000.00);