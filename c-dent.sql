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

-- Inserción de los 10 Pacientes (2 originales + 8 nuevos)
INSERT INTO pacientes (rut, nombres, apellidos, fecha_nacimiento, email, telefono, direccion, activo) VALUES 
('11111111-1', 'Juan', 'Pérez', '1990-05-15', 'juan.perez@email.com', '+56911111111', 'Av. Siempreviva 123', TRUE),
('22222222-2', 'María', 'Gómez', '1985-10-20', 'maria.gomez@email.com', '+56922222222', 'Pasaje Los Aromos 456', TRUE),
('13333333-3', 'Pedro', 'Soto', '1992-08-12', 'pedro.soto@email.com', '+56933333331', 'Calle Las Rosas 789', TRUE),
('14444444-4', 'Camila', 'Rojas', '1988-11-30', 'camila.rojas@email.com', '+56944444441', 'Av. Providencia 1000', TRUE),
('15555555-5', 'Diego', 'Silva', '1995-03-25', 'diego.silva@email.com', '+56955555551', 'Alameda 432', TRUE),
('16666666-6', 'Valentina', 'Torres', '1991-07-14', 'valentina.torres@email.com', '+56966666661', 'Calle Prat 56', TRUE),
('17777777-7', 'Matías', 'Muñoz', '1980-01-05', 'matias.munoz@email.com', '+56977777771', 'Av. Kennedy 8900', TRUE),
('18888888-8', 'Isidora', 'Castro', '1998-09-18', 'isidora.castro@email.com', '+56988888881', 'Pasaje El Sol 34', TRUE),
('19999999-9', 'Benjamín', 'Morales', '1983-12-02', 'benjamin.morales@email.com', '+56999999991', 'Calle San Diego 555', TRUE),
('10000000-K', 'Sofía', 'Vega', '1996-04-22', 'sofia.vega@email.com', '+56900000003', 'Av. Florida 1234', TRUE);

-- Inserción de 5 Contactos de Emergencia
INSERT INTO contactos_emergencia (nombre_contacto, telefono_contacto, parentesco, id_paciente) VALUES
('Pedro Pérez Padre', '+56900000001', 'Padre', 1),
('Ana Gómez Hermana', '+56900000002', 'Hermana', 2),
('Luis Soto Hermano', '+56900000004', 'Hermano', 3),
('Marta Rojas Madre', '+56900000005', 'Madre', 4),
('José Silva Padre', '+56900000006', 'Padre', 5);

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