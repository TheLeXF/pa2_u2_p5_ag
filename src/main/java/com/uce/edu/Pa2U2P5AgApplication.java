package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creamos un libro
		Libro l1= new Libro();
		
		l1.setTitulo("JAVA");
		l1.setFechaPublicacion(LocalDateTime.now());
		//Creamos dos Autores
		Autor a1 = new Autor();
		a1.setNacionalidad("Ecuatoriano");
		a1.setNombre("Pepito Perez");

		
		Autor a2 = new Autor();
		a2.setNacionalidad("Ecuatoriano");
		a2.setNombre("Daniel Teran");
		
		//Hacemos una coleccion de los autores
		Set<Autor>autores=new HashSet<Autor>();
		autores.add(a1);
		autores.add(a2);
		
		l1.setAutores(autores);
		
		//Hacemos una coleccion de los libros
		Set<Libro>libros=new HashSet<Libro>();
		libros.add(l1);
		
		a1.setLibros(libros);
		a2.setLibros(libros);
		
		this.libroService.guardar(l1);
	}

}
