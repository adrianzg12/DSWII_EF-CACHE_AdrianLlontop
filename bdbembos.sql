-- Crear la base de datos
CREATE DATABASE bdbembos;
USE bdbembos;

-- Tabla 1: Producto
CREATE TABLE Producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    disponibilidad BOOLEAN NOT NULL
);

-- Tabla 2: Cliente
CREATE TABLE Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255) NOT NULL
);

-- Tabla 3: Pedido
CREATE TABLE Pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    cliente_id BIGINT,
    estado VARCHAR(50) NOT NULL,
    CONSTRAINT FK_Pedido_Cliente FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

-- Tabla 4: PedidoDetails
CREATE TABLE PedidoDetails (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    producto_id BIGINT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_PedidoDetalle_Pedido FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    CONSTRAINT FK_Pedido_Detalle_Producto FOREIGN KEY (producto_id) REFERENCES Producto(id)
);

-- Tabla 5: Local
CREATE TABLE Local (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20)
);

-- Insertar datos de ejemplo en la tabla Producto
INSERT INTO Producto (nombre, descripcion, precio, disponibilidad) VALUES
('Hamburguesa Clásica', 'Hamburguesa con carne de res, lechuga, tomate y queso', 15.00, TRUE),
('Hamburguesa Doble', 'Hamburguesa con doble carne de res, lechuga, tomate y queso', 20.00, TRUE),
('Papas Fritas', 'Papas fritas medianas', 8.00, TRUE),
('Gaseosa', 'Gaseosa de 500ml', 5.00, TRUE),
('Agua Mineral', 'Botella de agua de 500ml', 4.00, TRUE);

-- Insertar datos de ejemplo en la tabla Cliente
INSERT INTO Cliente (nombre, apellido, email, telefono, direccion) VALUES
('Luis', 'Sánchez', 'luis.sanchez@mail.com', '987654321', 'Av. Larco 123, Lima'),
('Carla', 'Ramos', 'carla.ramos@mail.com', '987654322', 'Jr. Puno 456, Lima'),
('Javier', 'Morales', 'javier.morales@mail.com', '987654323', 'Av. José Larco 789, Lima'),
('Sofia', 'Cruz', 'sofia.cruz@mail.com', '987654324', 'Av. Arenales 101, Lima'),
('Andrés', 'Pérez', 'andres.perez@mail.com', '987654325', 'Av. Brasil 456, Lima');

-- Insertar datos de ejemplo en la tabla Pedido
INSERT INTO Pedido (fecha, cliente_id, estado) VALUES
('2024-10-01', 1, 'Entregado'),
('2024-10-02', 2, 'Entregado'),
('2024-10-03', 3, 'Entregado'),
('2024-10-04', 4, 'Entregado'),
('2024-10-05', 5, 'Entregado');

-- Insertar datos de ejemplo en la tabla PedidoDetails
INSERT INTO PedidoDetails (pedido_id, producto_id, cantidad, precio_unitario) VALUES
(1, 1, 1, 15.00),  -- Hamburguesa Clásica
(1, 3, 1, 8.00),   -- Papas Fritas
(1, 4, 1, 5.00),   -- Gaseosa
(2, 2, 1, 20.00),  -- Hamburguesa Doble
(2, 5, 1, 4.00),   -- Agua Mineral
(3, 1, 1, 15.00),
(3, 2, 1, 20.00),
(4, 1, 1, 15.00),
(5, 2, 1, 20.00);

-- Insertar datos de ejemplo en la tabla Local
INSERT INTO Local (nombre, direccion, telefono) VALUES
('Bembos Larcomar', 'Av. Larcomar, Miraflores', '012345678'),
('Bembos San Isidro', 'Av. Camino Real, San Isidro', '012345679'),
('Bembos Plaza Norte', 'Av. Universitaria, Independencia', '012345680');

SELECT * FROM Pedido WHERE estado = "Entregado"