package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		System.out.println("Query");
		
		List<Libro> lista = this.libroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : lista) {
			System.out.println(libro);
		}

		System.out.println("TypedQuery");

		Libro l1 = this.libroService.buscarPorTitulo("Programacion web");
		System.out.println(l1);

		List<Libro> lista2 = this.libroService.buscarPorFechaPubli(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : lista2) {
			System.out.println(libro);
		}
		System.out.println("Named Query");

		Libro l2 = this.libroService.buscarPorTituloNamed("Programacion Avanzada 2");
		System.out.println(l2);

		List<Libro> lista3 = this.libroService.buscarPorFechaNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : lista3) {
			System.out.println(libro);
		}
	}

}
