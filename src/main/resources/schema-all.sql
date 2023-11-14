DROP TABLE IF EXISTS persona;
CREATE TABLE persona (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    primer_nombre VARCHAR(20),
    segundo_nombre VARCHAR(20),
    dni VARCHAR(10)
);