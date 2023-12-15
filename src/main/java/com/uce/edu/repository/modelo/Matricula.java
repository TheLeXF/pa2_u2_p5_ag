package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula")
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Column(name = "matri_id")
	private Integer id;

	@Column(name = "matri_no_matricula")
	private String noMatricula;

	@Column(name = "matri_fecha_matricula")
	private LocalDateTime fechaMatricula;

	@Column(name = "matri_no_materias")
	private Integer noMaterias;

	@Column(name = "matri_valor")
	private BigDecimal valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNoMaterias() {
		return noMaterias;
	}

	public void setNoMaterias(Integer noMaterias) {
		this.noMaterias = noMaterias;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
