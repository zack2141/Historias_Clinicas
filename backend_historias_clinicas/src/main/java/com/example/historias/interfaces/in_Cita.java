package com.example.historias.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.historias.modelo.cita;
import com.example.historias.modelo.medico;
import com.example.historias.modelo.paciente;

public interface in_Cita extends JpaRepository<cita, Long> {
	
	public List<cita>findByIDpacienteAndEstado(paciente IDpaciente, String estado );
	
	public List<cita> findByIDmedicoAndFecha(medico IDmedico, Date fecha);
	
    public List<cita> findByFecha(Date fecha);

    @Query("SELECT c FROM cita c WHERE c.fecha = DATE(CURRENT_DATE) and c.estado = 'Asignada'")
    List<cita> citasDelDia();
    
    
    @Query("SELECT c FROM cita c WHERE c.fecha = DATE(CURRENT_DATE) and c.estado = 'Ingresado'")
    List<cita> citasDelDia2();
    

    public cita findByIDpacienteAndFechaAndEstado(paciente paci, Date fecha, String estado);
}
