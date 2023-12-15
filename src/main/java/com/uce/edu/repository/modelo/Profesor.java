package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor")
	@SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize = 1)
	@Column(name = "prof_id")
	private Integer id;

	@Column(name = "prof_cedula")
	private String cedula;

	@Column(name = "prof_nombre")
	private String nombre;

	@Column(name = "prof_apellido")
	private String apellido;

	@Column(name = "prof_facultad")
	private String facultad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


}
