package com.example.historias.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historias.modelo.loguin_Recepcionista;

public interface in_Loguin_Recepcionista  extends JpaRepository<loguin_Recepcionista, String>{
	
	loguin_Recepcionista findByUsuarioRecepAndPasswordRecep(String usuarioRecep, String passwordRecep); 

}
