package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Criteria Api Query
		
		Ciudadano ciu = this.ciudadanoService.buscarPorApellido("Espin");
		System.out.println(ciu);
		
		//
		Ciudadano ciu2 = this.ciudadanoService.buscarPorCriteria("Alexis", "Guanoluisa", "1727450296");
		System.out.println(ciu2);
		//
		Ciudadano ciu3 = this.ciudadanoService.buscarPorCriteria("Santiago", "Narvaez", "0514741746");
		System.out.println(ciu3);
		//
		Ciudadano ciu4 = this.ciudadanoService.buscarPorCriteria("Gerardo", "Lopez", "0614741746");
		System.out.println(ciu4);
		//
		System.out.println("Criteria Api Query And Or");
		Ciudadano ciu5 = this.ciudadanoService.buscarPorCriteriaAndOr("Alexis", "Juarez", "1727450296");
		System.out.println(ciu5);
		
		Ciudadano ciu6 = this.ciudadanoService.buscarPorCriteriaAndOr("Alexis", "Guanoluisa", "1727450296");
		System.out.println(ciu6);
	}

}
