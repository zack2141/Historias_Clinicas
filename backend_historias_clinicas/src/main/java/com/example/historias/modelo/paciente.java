package com.example.historias.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity  
@Table(name ="Paciente")

public class paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Paciente")
	private Long IDpaciente;
	
	
	@Column(name="Nombres")
	private String nombres;
	
	@Column(name="Apellidos")
	private String apellidos;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yy")
	@Column(name="Fecha_Nacimiento")
	private Date fechaNacimiento;
	
	@Column(name="Sexo")
	private String sexo;
	
	@Column(name="Estado_civil")
	private String estadoCivil;
	
	@Column(name="Rol_Paciente")
	private String rolPaciente;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="RH")
	private String rh;
	
	@Column(name="Correo")
	private String correo;
	
	@Column(name="Telefono")
	private String telefono;
	
	@Column(name="Afiliacion")
	private String afiliacion;

	public paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public paciente(String nombres, String apellidos, Date fechaNacimiento, String sexo, String estadoCivil,
			String rolPaciente, String direccion, String rh, String correo, String telefono, String afiliacion) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.rolPaciente = rolPaciente;
		this.direccion = direccion;
		this.rh = rh;
		this.correo = correo;
		this.telefono = telefono;
		this.afiliacion = afiliacion;
	}

	public Long getIDpaciente() {
		return IDpaciente;
	}

	public void setIDpaciente(Long iDpaciente) {
		IDpaciente = iDpaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRolPaciente() {
		return rolPaciente;
	}

	public void setRolPaciente(String rolPaciente) {
		this.rolPaciente = rolPaciente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAfiliacion() {
		return afiliacion;
	}

	public void setAfiliacion(String afiliacion) {
		this.afiliacion = afiliacion;
	}
	
	
	

}
