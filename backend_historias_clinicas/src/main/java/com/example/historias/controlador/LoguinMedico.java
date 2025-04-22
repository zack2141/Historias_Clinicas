package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Loguin_Medico;
import com.example.historias.modelo.loguin_Medico;
import com.example.historias.modelo.medico;

@RestController
@RequestMapping("/Loguin")
@CrossOrigin(origins = "http://localhost:4200/")

public class LoguinMedico {
	
	public loguin_Medico medic;
	
	
	    @Autowired
	    private in_Loguin_Medico loguinMedicoRepo;

	    @GetMapping("/LogueoMedico")
	    public String validarLogueo(@RequestParam String usuarioMedico, @RequestParam String passwordMedico) {
	        loguin_Medico medico = loguinMedicoRepo.findByUsuarioMedicoAndPasswordMedico(usuarioMedico, passwordMedico);
	        if (medico != null) {
	        	
	            medic=medico;
	            
	            String rol =medico.getIDmedico().getRolMedico();
	            return rol;
	            
	        } else {
	            return "usuario o contraseña incorrectos";
	        }
	    }
	    @GetMapping("/CerrarSesionMedico")
	    public String CerrarSesion() {
	        medic = null;
	        return "sesion cerrada correctamente";
	    }
	}


