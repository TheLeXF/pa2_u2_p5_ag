package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Autowired
	private IAlumnoService alumnoService;

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private ILibroService libroService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IAutorService autorService;

	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Empleado ciu1 = this.ciudadanoService.buscarPorNombre("Silvia");
		System.out.println(ciu1);

		Autor autor = this.autorService.buscarPorNacionalidad("Chileno");
		System.out.println(autor);

		Alumno a1 = this.alumnoService.buscarPorNoMatricula("123");
		System.out.println(a1);
		
		List<Alumno> a2 = this.alumnoService.buscarPorFechaMatricula(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Alumno alumno : a2) {
			System.out.println(alumno);
		}

		Estudiante e1 = this.estudianteService.seleccionarPorCedula("1727450296");
		System.out.println(e1);

		Estudiante e2 = this.estudianteService.seleccionarPorNombre("Alexis");
		System.out.println(e2);

		Libro l1 = this.libroService.buscarPorTitulo("La Mano");
		System.out.println(l1);

		List<Libro> l2 = this.libroService.buscarPorArea("Programacion");
		for (Libro libro : l2) {
			System.out.println(libro);
		}
		
		Hotel h1 = this.hotelService.buscarPorDireccion("Av. Orellana");
		System.out.println(h1);
		
		Habitacion ha1= this.habitacionService.buscarPorNumero("A15");
		System.out.println(ha1);
		
		/*
		Libro l1= new Libro();
		l1.setArea("Salud");
		l1.setEditorial("Oceano");
		l1.setFechaPublicacion(LocalDateTime.now());
		l1.setTitulo("Sistologia Gonzalez");
		Autor autor= new Autor();
		autor.setNacionalidad("EEUU");
		autor.setNombre("Jorge Gonzalez");
		Set<Autor>a= new HashSet<>();
		a.add(autor);
		l1.setAutores(a);
		this.libroService.guardar(l1);
		
		Libro l2= new Libro();
		l2.setArea("Lenguaje");
		l2.setEditorial("Internacional");
		l2.setFechaPublicacion(LocalDateTime.now());
		l2.setTitulo("La Mano");
		Autor autor2= new Autor();
		autor.setNacionalidad("España");
		autor.setNombre("Erick Loaiza");
		Set<Autor>a2= new HashSet<>();
		a2.add(autor2);
		l1.setAutores(a2);
		this.libroService.guardar(l2);*/
	}

}
