package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner {

	@Autowired
	private IAutorService autorService;

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private ILibroService libroService;
	
	@Autowired
	private IEstudianteService estudianteService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Criteria Api Query
		Autor a1 = this.autorService.buscarPorNacionalidadNombre("Daniel", "Chileno");
		System.out.println(a1);
		
		Hotel h1= this.hotelService.buscarPorNombreDireccion("Marriot", "Av. Orellana");
		System.out.println(h1);
		
		Habitacion h2 = this.habitacionService.buscarPorCriteria("Economica", "A20");
		System.out.println(h2);
		
		List<Libro> l1 = this.libroService.buscarPorAreaOrEditorial("Programacion", "Santillana", "JAVA para principiantes");
		for (Libro libro: l1) {
			System.out.println(libro);
		}
		
		Estudiante e1 = this.estudianteService.buscarPorNombreAndCedula("Alexis","Guanoluisa","1727450296");
		System.out.println(e1);
		
	}

}
