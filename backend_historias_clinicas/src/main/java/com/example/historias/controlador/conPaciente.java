package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Loguin_Paciente;
import com.example.historias.interfaces.in_Paciente;
import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.paciente;

@RestController
@RequestMapping("/Paciente")
@CrossOrigin(origins = "http://localhost:4200")

public class conPaciente {
	
	    @Autowired
	    private in_Paciente repPa;

	    @Autowired
	    private in_Loguin_Paciente repLoPa;
	    
	    @Autowired
		private LoguinPaciente conLoPa;// para acceder a los metodos del controlador de LoguinPaciente//


	    @PostMapping("/registrar")
	    public boolean registrarPacienteConLogin(
	    		@RequestBody loguin_Paciente nuevoPaciente) {
	                         

	        // Verificar si el correo o el usuario ya existen
	        if (repPa.findByCorreo(nuevoPaciente.getIDpaciente().getCorreo()) != null || 
	            repLoPa.findByUsuarioPaciente(nuevoPaciente.getUsuarioPaciente()) != null) {
	            return false;
	        }
	        
	        nuevoPaciente.getIDpaciente().setRolPaciente("Paciente");

	        // Guardar paciente
	        paciente pacienteGuardado = repPa.save(nuevoPaciente.getIDpaciente());

	        // Crear login y guardar
	        loguin_Paciente login = new loguin_Paciente(nuevoPaciente.getUsuarioPaciente(),nuevoPaciente.getPassword() , pacienteGuardado);
	        repLoPa.save(login);

	        return true;
	    }

	    @PostMapping("/ActualizarPaciente")
	    public boolean actualizaPaciente(
	            @RequestBody loguin_Paciente act) {
	    	
	    	this.repPa.save(act.getIDpaciente());
	    	
	    	this.repLoPa.save(act);
	    	
	    	this.conLoPa.usu = act;

	        return true;
	    }


	    //Obtener datos del paciente
	    @GetMapping("/ObtenerPaciente")
	    public loguin_Paciente verPaciente(@RequestParam String id) {
	    	
	        return this.repLoPa.findByUsuarioPaciente(id);
	    }
}



	   