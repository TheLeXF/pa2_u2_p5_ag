package com.uce.edu;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner{
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Hotel h1 = new Hotel();
		
		h1.setNombre("Tambo Real");
		h1.setDireccion("12 de Octubre");
		
		
		Habitacion hab1=new Habitacion();
		hab1.setClase("Economica");
		hab1.setNumero("A1");
		hab1.setHotel(h1);
		
		Habitacion hab2=new Habitacion();
		hab2.setClase("Presidencial");
		hab2.setNumero("P1");
		hab2.setHotel(h1);
		
		List<Habitacion>Habitaciones = new ArrayList<>();
		Habitaciones.add(hab1);
		Habitaciones.add(hab2);
		
		h1.setHabitaciones(Habitaciones);
		this.hotelService.guardar(h1);
	}

}
