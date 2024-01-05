package com.uce.edu;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner{
	
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Hotel htemp= new Hotel();
		
		htemp.setDireccion("Av. Orellana");
		htemp.setNombre("Marriot");
		
		Habitacion hab4= new Habitacion();
		hab4.setClase("Ejecutiva Empresarial");
		hab4.setHotel(htemp);
		hab4.setNumero("A31");
		List<Habitacion>Habitaciones2 = new ArrayList<>();
		Habitaciones2.add(hab4);
		this.hotelService.guardar(htemp);
		
		
		
		Habitacion hab1= new Habitacion();
		hab1.setClase("Ejecutiva Empresarial");
		Hotel hb = this.hotelService.buscar(2);
		hab1.setHotel(hb);
		hab1.setNumero("A20");
	
		Habitacion hab2= new Habitacion();
		hab2.setClase("Economica");
		hab2.setHotel(hb);
		hab2.setNumero("A15");

		List<Habitacion>Habitaciones = new ArrayList<>();
		Habitaciones.add(hab1);
		Habitaciones.add(hab2);
		
		hb.setHabitaciones(Habitaciones);
		hb.setDireccion("Av. Amazonas");
		this.hotelService.actualizar(hb);
		
		Habitacion hab3= this.habitacionService.buscar(3);
		hab3.setClase("Pet Friendly");
		this.habitacionService.actualizar(hab3);
		
		this.habitacionService.borrar(1);
		
		
		
				
	}

}
