package com.example.historias.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.historias.modelo.cita;
import com.example.historias.modelo.medico;
import com.example.historias.modelo.paciente;

public interface in_Cita extends JpaRepository<cita, Long> {
	
	public List<cita>findByPacienteAndEstadoCi(paciente paciente,String estado );
	
	public List<cita> findByIdmedicoAndFecha(medico med, Date fecha);
	
    public List<cita> findByFecha(Date fecha);

    @Query("SELECT c FROM Cita c WHERE c.fecha = CURRENT_DATE")
    List<cita> citasDelDia();

}
