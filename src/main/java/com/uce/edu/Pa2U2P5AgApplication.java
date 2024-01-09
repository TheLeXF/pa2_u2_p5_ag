package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		
		//Creamos dos libros
		Libro2 l1= new Libro2();
		l1.setTitulo("JAVA2");
		l1.setFechaPublicacion(LocalDateTime.now());
		
		//Creamos un autor
		Autor2 a1 = new Autor2();
		a1.setNacionalidad("Ecuatoriano2");
		a1.setNombre("Pepito Perez2");
		
		Autor2 a2 = new Autor2();
		a2.setNacionalidad("Ecuatoriano2");
		a2.setNombre("Daniel Teran2");
		
		
		List<Autor2>autores=new ArrayList<Autor2>();
		autores.add(a1);
		autores.add(a2);
		
		AutorLibro autorLibro1= new AutorLibro();
		autorLibro1.setLibro2(l1);
		autorLibro1.setAutor2(a1);
		autorLibro1.setFecha(LocalDateTime.now());
		
		AutorLibro autorLibro2= new AutorLibro();
		autorLibro2.setLibro2(l1);
		autorLibro2.setAutor2(a2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		List <AutorLibro>lista = new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		l1.setAutoresLibros(lista);
		
		//this.libroService.guardar(l1);
		Libro l2=this.libroService.buscarrPorNombre("JAVA para principiantes");
		System.out.println(l2);
		
		
		
		
	}

}
