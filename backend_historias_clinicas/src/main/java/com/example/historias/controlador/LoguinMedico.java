package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Loguin_Medico;
import com.example.historias.modelo.loguin_Medico;
import com.example.historias.modelo.medico;

@RestController
@CrossOrigin(origins = "http://localhost:8080/loguin/Medico")

public class LoguinMedico {
	
	public medico medic;
	
	
	    @Autowired
	    private in_Loguin_Medico loguinMedicoRepo;

	    @GetMapping("/Logueo")
	    public String validarLogueo(@RequestParam String usuarioMedico, @RequestParam String passwordMedico) {
	        loguin_Medico medico = loguinMedicoRepo.findByUsuarioMedicoAndPasswordMedico(usuarioMedico, passwordMedico);
	        if (medico != null) {
	        	medico  medi= medico.getIDmedico();
	            medic=medi;
	            
	            String rol =medi.getRolMedico();
	            return rol;
	            
	        } else {
	            return "usuario o contraseña incorrectos";
	        }
	    }
	    @GetMapping("/cerrarSesion")
	    public String cerrarSesion() {
	        medic = null;
	        return "sesion cerrada correctamente";
	    }
	}


