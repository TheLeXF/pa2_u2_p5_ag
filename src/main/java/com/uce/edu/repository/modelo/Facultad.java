package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "facultad")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_facultad")
	@SequenceGenerator(name = "seq_facultad", sequenceName = "seq_facultad", allocationSize = 1)
	@Column(name = "facu_id")
	private Integer id;

	@Column(name = "facu_nombre")
	private String nombre;

	@Column(name = "facu_no_estudiantes")
	private Integer noEstudiantes;

	@Column(name = "facu_no_carreras")
	private Integer noCarreras;

	@Column(name = "facu_no_aulas")
	private Integer noAulas;

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

	public Integer getNoEstudiantes() {
		return noEstudiantes;
	}

	public void setNoEstudiantes(Integer noEstudiantes) {
		this.noEstudiantes = noEstudiantes;
	}

	public Integer getNoCarreras() {
		return noCarreras;
	}

	public void setNoCarreras(Integer noCarreras) {
		this.noCarreras = noCarreras;
	}

	public Integer getNoAulas() {
		return noAulas;
	}

	public void setNoAulas(Integer noAulas) {
		this.noAulas = noAulas;
	}

}
