package com.example.historias.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historias.modelo.cita;
import com.example.historias.modelo.paciente;

public interface in_Cita extends JpaRepository<cita, Long> {
	
	public List<cita>findByPacienteAndEstadoCi(paciente paciente,String estado );

}
