package com.uce.edu.repository.modelo;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alumno")
	@SequenceGenerator(name="seq_alumno",sequenceName="seq_alumno",allocationSize = 1)
	@Column(name="alum_id")
	private Integer id;
	
	@Column(name="alum_nombre")
	private String nombre;
	
	@Column(name="alum_no_matricula")
	private String noMatricula;
	
	@Column(name = "alum_fecha_matricula")
	private LocalDateTime fechaMatricula;
	
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
	public String getNoMatricula() {
		return noMatricula;
	}
	public void setNoMatricula(String noMatricula) {
		this.noMatricula = noMatricula;
	}
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", noMatricula=" + noMatricula + ", fechaMatricula=" + fechaMatricula + "]";
	}
	
}
