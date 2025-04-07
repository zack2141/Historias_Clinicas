package com.example.historias.modelo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity  
@Table(name ="Loguin_Paciente")

public class loguin_Paciente {
	
	@Id
	@Column(name = "Usuario_Paciente")
	private String usuarioPaciente;
	
	
	@Column(name="Password")
	private String password;
	
	@OneToOne()
	@JoinColumn(name = "ID_Paciente", referencedColumnName = "ID_Paciente")
	private paciente IDpaciente;

	public loguin_Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public loguin_Paciente(String usuarioPaciente, String password, paciente iDpaciente) {
		super();
		this.usuarioPaciente = usuarioPaciente;
		this.password = password;
		IDpaciente = iDpaciente;
	}

	public String getUsuarioPaciente() {
		return usuarioPaciente;
	}

	public void setUsuarioPaciente(String usuarioPaciente) {
		this.usuarioPaciente = usuarioPaciente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public paciente getIDpaciente() {
		return IDpaciente;
	}

	public void setIDpaciente(paciente iDpaciente) {
		IDpaciente = iDpaciente;
	}


	

}
