package com.example.historias.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Historia_Clinica;
import com.example.historias.modelo.historia_Clinica;


@RestController
@RequestMapping("/Ver/HistorialClinico")
@CrossOrigin(origins = "http://localhost:4200/")
public class conHistoriaClinica {
	
	@Autowired
	private in_Historia_Clinica repHistoriaClinica;
	
	
	@Autowired
	private LoguinMedico LogMedico;
	
	@Autowired
	private Cita_Controlador conCita;
	
	
	
	@PostMapping("/guardarHistorialClinico")
	public String guardarHistorial(@RequestBody historia_Clinica historia, @RequestParam Long idcita) {
	    try {
	    	
	    	boolean resul =this.conCita.asistenciaPaciente(idcita);
	    	
	    	if(resul == true) {
	    		historia.setIDmedico(this.LogMedico.medic.getIDmedico());	
	    		repHistoriaClinica.save(historia);
	    		return "Historial clínico registrado correctamente.";
	    		
	    	}else {
	    		return "Error al registrar historial.";
	    	}
	    	
	    	
	    	
	    } catch (Exception e) {
	        return "Error al registrar historial.";
	    }

	}
	
	
	@GetMapping("/ver")
	public List<historia_Clinica> guardarHistorial() {
	   
		return this.repHistoriaClinica.findAll();
	}
	
	
	
}

	
	


