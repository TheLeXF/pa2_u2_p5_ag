package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrera")
	@SequenceGenerator(name = "seq_carrera", sequenceName = "seq_carrera", allocationSize = 1)
	@Column(name = "carre_id")
	private Integer id;

	@Column(name = "carre_nombre")
	private String nombre;

	@Column(name = "carre_facultad")
	private String facultad;

	@Column(name = "carre_director")
	private String Director;

	@Column(name = "carre_no_estudiantes")
	private Integer noEstudiantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public Integer getNoEstudiantes() {
		return noEstudiantes;
	}

	public void setNoEstudiantes(Integer noEstudiantes) {
		this.noEstudiantes = noEstudiantes;
	}

}
