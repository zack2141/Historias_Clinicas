package com.example.historias.modelo;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity  
@Table(name ="Cita")

public class cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Cita")
	private Long IDcita;
	
	@Column(name = "Motivo_Cita")
	private String motivoCita;
	
	@Column(name = "Estado")
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yy")
	@Column(name = "Fecha")
	private Date Fecha;
	
	@Column(name = "Hora")
	private String hora;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Paciente", referencedColumnName = "ID_Paciente")
	private paciente IDpaciente;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Medico", referencedColumnName = "ID_Medico")
	private medico IDmedico;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Recepcionista", referencedColumnName = "ID_Recepcionista")
	private recepcionista IDrecepcionista;

	public cita() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public cita(String motivoCita, String estado, Date fecha, String hora, paciente iDpaciente, medico iDmedico,
			recepcionista iDrecepcionista) {
		super();
		this.motivoCita = motivoCita;
		this.estado = estado;
		Fecha = fecha;
		this.hora = hora;
		IDpaciente = iDpaciente;
		IDmedico = iDmedico;
		IDrecepcionista = iDrecepcionista;
	}



	public Long getIDcita() {
		return IDcita;
	}

	public void setIDcita(Long iDcita) {
		IDcita = iDcita;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public paciente getIDpaciente() {
		return IDpaciente;
	}

	public void setIDpaciente(paciente iDpaciente) {
		IDpaciente = iDpaciente;
	}

	public medico getIDmedico() {
		return IDmedico;
	}

	public void setIDmedico(medico iDmedico) {
		IDmedico = iDmedico;
	}

	public recepcionista getIDrecepcionista() {
		return IDrecepcionista;
	}

	public void setIDrecepcionista(recepcionista iDrecepcionista) {
		IDrecepcionista = iDrecepcionista;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
