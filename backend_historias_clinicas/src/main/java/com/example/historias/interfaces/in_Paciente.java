package com.example.historias.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.paciente;

public interface in_Paciente extends JpaRepository<paciente, Long> {
<<<<<<< HEAD
=======

>>>>>>> 2168c1b63f9b2167e0b300e9ed8095992fc09c65
	

	String findByCorreo(String correo);

	paciente findByCorreo(String correo);

<<<<<<< HEAD
=======


>>>>>>> 2168c1b63f9b2167e0b300e9ed8095992fc09c65

}
