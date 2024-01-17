package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
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
		
		Empleado emp1= this.ciudadanoService.buscarPorCedula("1727450296");
		System.out.println(emp1);
		
		Ciudadano ciu1 = this.ciudadanoService.buscarPorCedulaCiu("1727450296");
		System.out.println(ciu1);
	}

}
