package com.hgallgo.prueba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/prueba_surtitodo";
    private final static String USER = "root";
    private final static String PASSWORD = "";

    private final static String SQL_DROP_TIPO_DOCUMENTO = """
            DROP TABLE IF EXISTS tipo_documento;
            """;
    private final static String SQL_CREATE_TIPO_DOCUMENTO = """
            CREATE TABLE tipo_documento(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            TIPO VARCHAR(50) NOT NULL,
            DESCRIPCION VARCHAR(150) NOT NULL
            );           
            
            """;

    private final static String SQL_DROP_CIUDAD = """
            DROP TABLE IF EXISTS ciudad;
            """;

    private final static String SQL_CREATE_CIUDAD = """
            CREATE TABLE ciudad(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            NOMBRE VARCHAR(150) NOT NULL
            );
            """;

    private final static String SQL_DROP_PERSONA = """
            DROP TABLE IF EXISTS persona;
            """;

    private final static String SQL_CREATE_PERSONA = """
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
            """;

    private final static String SQL_INSERT_TIPO_DOCUMENTOS = """
            INSERT INTO tipo_documento(tipo, descripcion)
            VALUES('Cédula de ciudadanía', 'Documento otorgado a los colombianos mayores de 18 años'),
            ('Cédula de extranjería', 'Documento otorgado a residentes extranjero en colombia');
            """;

    private final static String SQL_INSERT_CIUDADES = """
            INSERT INTO ciudad(nombre) 
            VALUES('Medellín'),('Bogotá');
            """;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //Cargo el driver de MySql
        Class.forName(DRIVER);

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            //Borra y crea la tabla tipo_documento
            statement.execute(SQL_DROP_TIPO_DOCUMENTO);
            statement.execute(SQL_CREATE_TIPO_DOCUMENTO);
            //Borra y crea la tabla ciudad
            statement.execute(SQL_DROP_CIUDAD);
            statement.execute(SQL_CREATE_CIUDAD);
            //Borra y crea la tabla persona
            statement.execute(SQL_DROP_PERSONA);
            statement.execute(SQL_CREATE_PERSONA);
            //Inserta dos registros en ciudad y tipo_documento
            statement.execute(SQL_INSERT_TIPO_DOCUMENTOS);
            statement.execute(SQL_INSERT_CIUDADES);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
