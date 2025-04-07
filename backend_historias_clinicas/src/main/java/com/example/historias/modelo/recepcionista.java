package com.example.historias.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name ="Recepcionista")

public class recepcionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Recepcionista")
	private Long IDrecepcionista;
	
	
	@Column(name="Nombre_Recep")
	private String nombreRecep;
	
	@Column(name="Apellidos_Recepcionista")
	private String apellidosRecepcionista;
	
	@Column(name="Edad_Recep")
	private int EdadRecep;
	
	@Column(name="Rol_Recepcionista")
	private String rolRecepcionista;
	
	@Column(name="Turno_Recep")
	private String turnoRecep;
	
	@Column(name="Cargo_Recep")
	private String cargoRecep;
	
	@Column(name="Correo_Recep")
	private String correoRecep;
	
	@Column(name="Telefono_Recep")
	private String telefonoRecep;
	
	@Column(name="Direccion_Recep")
	private String direcionRecep;
	
	@Column(name="Residencia_Recep")
	private String residenciaRecep;
	
	@Column(name="Salario_Recep")
	private Long salarioRecep;

	public recepcionista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public recepcionista(String nombreRecep, String apellidosRecepcionista, int edadRecep, String rolRecepcionista,
			String turnoRecep, String cargoRecep, String correoRecep, String telefonoRecep, String direcionRecep,
			String residenciaRecep, Long salarioRecep) {
		super();
		this.nombreRecep = nombreRecep;
		this.apellidosRecepcionista = apellidosRecepcionista;
		EdadRecep = edadRecep;
		this.rolRecepcionista = rolRecepcionista;
		this.turnoRecep = turnoRecep;
		this.cargoRecep = cargoRecep;
		this.correoRecep = correoRecep;
		this.telefonoRecep = telefonoRecep;
		this.direcionRecep = direcionRecep;
		this.residenciaRecep = residenciaRecep;
		this.salarioRecep = salarioRecep;
	}

	public Long getIDrecepcionista() {
		return IDrecepcionista;
	}

	public void setIDrecepcionista(Long iDrecepcionista) {
		IDrecepcionista = iDrecepcionista;
	}

	public String getNombreRecep() {
		return nombreRecep;
	}

	public void setNombreRecep(String nombreRecep) {
		this.nombreRecep = nombreRecep;
	}

	public String getApellidosRecepcionista() {
		return apellidosRecepcionista;
	}

	public void setApellidosRecepcionista(String apellidosRecepcionista) {
		this.apellidosRecepcionista = apellidosRecepcionista;
	}

	public int getEdadRecep() {
		return EdadRecep;
	}

	public void setEdadRecep(int edadRecep) {
		EdadRecep = edadRecep;
	}

	public String getRolRecepcionista() {
		return rolRecepcionista;
	}

	public void setRolRecepcionista(String rolRecepcionista) {
		this.rolRecepcionista = rolRecepcionista;
	}

	public String getTurnoRecep() {
		return turnoRecep;
	}

	public void setTurnoRecep(String turnoRecep) {
		this.turnoRecep = turnoRecep;
	}

	public String getCargoRecep() {
		return cargoRecep;
	}

	public void setCargoRecep(String cargoRecep) {
		this.cargoRecep = cargoRecep;
	}

	public String getCorreoRecep() {
		return correoRecep;
	}

	public void setCorreoRecep(String correoRecep) {
		this.correoRecep = correoRecep;
	}

	public String getTelefonoRecep() {
		return telefonoRecep;
	}

	public void setTelefonoRecep(String telefonoRecep) {
		this.telefonoRecep = telefonoRecep;
	}

	public String getDirecionRecep() {
		return direcionRecep;
	}

	public void setDirecionRecep(String direcionRecep) {
		this.direcionRecep = direcionRecep;
	}

	public String getResidenciaRecep() {
		return residenciaRecep;
	}

	public void setResidenciaRecep(String residenciaRecep) {
		this.residenciaRecep = residenciaRecep;
	}

	public Long getSalarioRecep() {
		return salarioRecep;
	}

	public void setSalarioRecep(Long salarioRecep) {
		this.salarioRecep = salarioRecep;
	}
	
	
	

}
