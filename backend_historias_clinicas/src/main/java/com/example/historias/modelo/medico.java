package com.example.historias.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity  
@Table(name ="Medico")
public class medico {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Medico")
	private Long IDMedico;
	
	
	@Column(name="Nombre_Medico")
	private String nombreMedico;
	
	@Column(name="Apellidos_Medico")
	private String apellidosMedico;
	
	@Column(name="Edad_Medico")
	private int EdadMedico;
	
	@Column(name="Rol_Medico")
	private String rolMedico;
	
	@Column(name="Turno_Medico")
	private String turnoMedico;
	
	@Column(name="Cargo_Medico")
	private String cargoMedico;
	
	@Column(name="Correo_Medico")
	private String correoMedico;
	
	@Column(name="Telefono_Medico")
	private String telefonoMedico;
	
	@Column(name="Direccion_Medico")
	private String direcionMedico;
	
	@Column(name="Residencia_Medico")
	private String residenciaMedico;
	
	@Column(name="Salario_Medico")
	private Long salarioMedico;

	public medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public medico(String nombreMedico, String apellidosMedico, int edadMedico, String rolMedico, String turnoMedico,
			String cargoMedico, String correoMedico, String telefonoMedico, String direcionMedico,
			String residenciaMedico, Long salarioMedico) {
		super();
		this.nombreMedico = nombreMedico;
		this.apellidosMedico = apellidosMedico;
		EdadMedico = edadMedico;
		this.rolMedico = rolMedico;
		this.turnoMedico = turnoMedico;
		this.cargoMedico = cargoMedico;
		this.correoMedico = correoMedico;
		this.telefonoMedico = telefonoMedico;
		this.direcionMedico = direcionMedico;
		this.residenciaMedico = residenciaMedico;
		this.salarioMedico = salarioMedico;
	}

	public Long getIDMedico() {
		return IDMedico;
	}

	public void setIDMedico(Long iDMedico) {
		IDMedico = iDMedico;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidosMedico() {
		return apellidosMedico;
	}

	public void setApellidosMedico(String apellidosMedico) {
		this.apellidosMedico = apellidosMedico;
	}

	public int getEdadMedico() {
		return EdadMedico;
	}

	public void setEdadMedico(int edadMedico) {
		EdadMedico = edadMedico;
	}

	public String getRolMedico() {
		return rolMedico;
	}

	public void setRolMedico(String rolMedico) {
		this.rolMedico = rolMedico;
	}

	public String getTurnoMedico() {
		return turnoMedico;
	}

	public void setTurnoMedico(String turnoMedico) {
		this.turnoMedico = turnoMedico;
	}

	public String getCargoMedico() {
		return cargoMedico;
	}

	public void setCargoMedico(String cargoMedico) {
		this.cargoMedico = cargoMedico;
	}

	public String getCorreoMedico() {
		return correoMedico;
	}

	public void setCorreoMedico(String correoMedico) {
		this.correoMedico = correoMedico;
	}

	public String getTelefonoMedico() {
		return telefonoMedico;
	}

	public void setTelefonoMedico(String telefonoMedico) {
		this.telefonoMedico = telefonoMedico;
	}

	public String getDirecionMedico() {
		return direcionMedico;
	}

	public void setDirecionMedico(String direcionMedico) {
		this.direcionMedico = direcionMedico;
	}

	public String getResidenciaMedico() {
		return residenciaMedico;
	}

	public void setResidenciaMedico(String residenciaMedico) {
		this.residenciaMedico = residenciaMedico;
	}

	public Long getSalarioMedico() {
		return salarioMedico;
	}

	public void setSalarioMedico(Long salarioMedico) {
		this.salarioMedico = salarioMedico;
	}
	
	

}
