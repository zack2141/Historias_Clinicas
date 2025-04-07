package com.example.historias.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity  
@Table(name ="Loguin_Medico")
public class loguin_Medico {
	
	@Id
	@Column(name = "Usuario_Medico")
	private String usuarioMedico;
	
	
	@Column(name="Password_Medicp")
	private String passwordMedico;
	
	@OneToOne()
	@JoinColumn(name = "ID_Medico", referencedColumnName = "ID_Medico")
	private medico IDmedico;

	public loguin_Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public loguin_Medico(String usuarioMedico, String passwordMedico, medico iDmedico) {
		super();
		this.usuarioMedico = usuarioMedico;
		this.passwordMedico = passwordMedico;
		IDmedico = iDmedico;
	}

	public String getUsuarioMedico() {
		return usuarioMedico;
	}

	public void setUsuarioMedico(String usuarioMedico) {
		this.usuarioMedico = usuarioMedico;
	}

	public String getPasswordMedico() {
		return passwordMedico;
	}

	public void setPasswordMedico(String passwordMedico) {
		this.passwordMedico = passwordMedico;
	}

	public medico getIDmedico() {
		return IDmedico;
	}

	public void setIDmedico(medico iDmedico) {
		IDmedico = iDmedico;
	}
	
	

}
