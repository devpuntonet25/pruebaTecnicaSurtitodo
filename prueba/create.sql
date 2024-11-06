DROP TABLE IF EXISTS tipo_documento;

CREATE TABLE tipo_documento(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            TIPO VARCHAR(50) NOT NULL,
            DESCRIPCION VARCHAR(150) NOT NULL
            );

DROP TABLE IF EXISTS ciudad;

CREATE TABLE ciudad(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            NOMBRE VARCHAR(150) NOT NULL
            );

DROP TABLE IF EXISTS persona;

CREATE TABLE persona(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            TIPO_DOCUMENTO INT NOT NULL,
            CIUDAD INT NOT NULL,
            NOMBRE VARCHAR(150) NOT NULL,
            APELLIDO VARCHAR(150) NOT NULL,
            NUMERO_DOCUMENTO VARCHAR(12) NOT NULL,
            DIRECCION VARCHAR(100) NOT NULL,
            FECHA_INGRESO DATE NOT NULL
            );

INSERT INTO tipo_documento(tipo, descripcion)
            VALUES('Cédula de ciudadanía', 'Documento otorgado a los colombianos mayores de 18 años'),
            ('Cédula de extranjería', 'Documento otorgado a residentes extranjero en colombia');

INSERT INTO ciudad(nombre)
            VALUES('Medellín'),('Bogotá');
