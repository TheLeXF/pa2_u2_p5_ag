package com.uce.edu.transferencia.repository.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "cuenta_bancaria")
public class CuentaBancaria {
	@Id
	private String numero;
	private String cedulaPropietario;
	private BigDecimal saldo;
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCedulaPropietario() {
		return cedulaPropietario;
	}
	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", cedulaPropietario=" + cedulaPropietario + ", saldo=" + saldo
				+ "]";
	}

}
