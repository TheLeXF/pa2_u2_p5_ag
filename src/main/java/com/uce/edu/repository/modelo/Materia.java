package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mate_id")
	private Integer id;

	@Column(name = "mate_nombre")
	private String nombre;

	@Column(name = "mate_semestre")
	private Integer semestre;

	@Column(name = "mate_profesor")
	private String profesor;

	@Column(name = "mate_no_matriculados")
	private BigDecimal noMatriculados;

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

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public BigDecimal getNoMatriculados() {
		return noMatriculados;
	}

	public void setNoMatriculados(BigDecimal noMatriculados) {
		this.noMatriculados = noMatriculados;
	}

}
