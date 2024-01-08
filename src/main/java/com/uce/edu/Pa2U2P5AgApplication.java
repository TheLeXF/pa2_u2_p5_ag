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
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;
	@Autowired
	private IAutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creamos dos libros
		Libro l1= new Libro();
		
		l1.setTitulo("Cien años de soledad");
		l1.setFechaPublicacion(LocalDateTime.of(1969, 1, 1, 12, 0));
		
		Libro l2= new Libro();
		
		l1.setTitulo("El Amor en los tiempos de cólera");
		l1.setFechaPublicacion(LocalDateTime.of(1985, 1, 1, 12, 0));
		//Creamos un autor
		Autor a1 = new Autor();
		a1.setNacionalidad("Colombiano");
		a1.setNombre("Gabriel Garcia Marquez");
		
		Set<Libro>libros=new HashSet<Libro>();
		libros.add(l1);
		libros.add(l2);
		
		Set<Autor>autores=new HashSet<Autor>();
		autores.add(a1);
		
		a1.setLibros(libros);
		l1.setAutores(autores);
		
		this.autorService.guardar(a1);
		
		//Ingresar un libro con libroService
		Libro l3= new Libro();
		
		l3.setTitulo("Divina Comedia");
		l3.setFechaPublicacion(LocalDateTime.of(1265, 1, 1, 12, 0));
		
		Autor a2 = new Autor();
		a2.setNacionalidad("Italiano");
		a2.setNombre("Dante Alighieri");
		
		Autor a3 = new Autor();
		a3.setNacionalidad("Ecuatoriano");
		a3.setNombre("Juan Leon Mera");
		
		
		//Hacemos una coleccion de los autores
		Set<Autor>autores2=new HashSet<Autor>();
		autores2.add(a2);
		autores2.add(a3);
		
		l3.setAutores(autores2);
		
		//Hacemos una coleccion de los libros
		Set<Libro>libros2=new HashSet<Libro>();
		libros2.add(l3);
		
		a2.setLibros(libros2);
		a3.setLibros(libros2);
		
		this.libroService.guardar(l3);
		
		
		
		// Buscar y Actualizar libro 
		
		Libro l4=this.libroService.buscar(2);
		l4.setTitulo("JAVA para principiantes");
		this.libroService.actualizar(l4);
		
		//Borrar un autor
		
		this.autorService.borrar(a3.getId());
		// Buscar y Actualizar Autor
		
		Autor a4 = this.autorService.buscar(3);
		a4.setNacionalidad("Chileno");
		this.autorService.actualizar(a4);
		
		
	}

}
