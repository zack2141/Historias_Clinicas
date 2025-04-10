package com.example.historias.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historias.modelo.paciente;

public interface in_Paciente extends JpaRepository<paciente, Long> {
	

	String findByCorreo(String correo);

	paciente findByCorreo(String correo);


}
