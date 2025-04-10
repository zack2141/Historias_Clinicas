package com.example.historias.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historias.modelo.loguin_Paciente;


public interface in_Loguin_Paciente extends JpaRepository<loguin_Paciente, String>{

	    loguin_Paciente findByUsuarioPacienteAndPassword(String usuarioPaciente, String password);

	    loguin_Paciente findByUsuarioPaciente(String usuarioPaciente);
	}


