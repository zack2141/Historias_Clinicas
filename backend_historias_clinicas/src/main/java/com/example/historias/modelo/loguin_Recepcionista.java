package com.example.historias.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity  
@Table(name ="Loguin_Recepcionista")
public class loguin_Recepcionista {
	
	
	@Id
	@Column(name = "Usuario_Recep")
	private String usuarioRecep;
	
	
	@Column(name="Password_Recep")
	private String passwordRecep;
	
	@OneToOne()
	@JoinColumn(name = "ID_Recepcionista", referencedColumnName = "ID_Recepcionista")
	private recepcionista IDRecepcionista;

	public loguin_Recepcionista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public loguin_Recepcionista(String usuarioRecep, String passwordRecep, recepcionista iDRecepcionista) {
		super();
		this.usuarioRecep = usuarioRecep;
		this.passwordRecep = passwordRecep;
		IDRecepcionista = iDRecepcionista;
	}

	public String getUsuarioRecep() {
		return usuarioRecep;
	}

	public void setUsuarioRecep(String usuarioRecep) {
		this.usuarioRecep = usuarioRecep;
	}

	public String getPasswordRecep() {
		return passwordRecep;
	}

	public void setPasswordRecep(String passwordRecep) {
		this.passwordRecep = passwordRecep;
	}

	public recepcionista getIDRecepcionista() {
		return IDRecepcionista;
	}

	public void setIDRecepcionista(recepcionista iDRecepcionista) {
		IDRecepcionista = iDRecepcionista;
	}
	
	
	

}
