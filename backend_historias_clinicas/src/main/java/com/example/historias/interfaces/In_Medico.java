package com.example.historias.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.historias.modelo.medico;



public interface In_Medico extends JpaRepository<medico, Long>{
	
	@Query("SELECT m FROM medico m WHERE m.cargoMedico = :cargoMedico AND " +
		       "NOT EXISTS (" +
		       "   SELECT c FROM cita c WHERE c.IDmedico = m AND c.fecha = :fecha AND c.hora = :hora" +
		       ")")
		List<medico> medicosDisponibles(@Param("hora") String hora,
				                        @Param("fecha") Date fecha,
		                                @Param("cargoMedico") String cargoMedico);

}
