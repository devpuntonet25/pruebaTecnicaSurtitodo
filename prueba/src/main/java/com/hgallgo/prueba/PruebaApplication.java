package com.hgallgo.prueba;

import com.hgallgo.prueba.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {
		DB.createTables();//Primero crea la base de datos
		SpringApplication.run(PruebaApplication.class, args);
	}

}
