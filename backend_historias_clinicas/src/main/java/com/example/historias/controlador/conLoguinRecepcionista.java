package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Loguin_Recepcionista;
import com.example.historias.modelo.loguin_Recepcionista;
import com.example.historias.modelo.recepcionista;

@RestController
@RequestMapping("/Loguin")
@CrossOrigin(origins = "http://localhost:4200/")

public class conLoguinRecepcionista {
	
	    public recepcionista recepLogueado;

	    @Autowired
	    private in_Loguin_Recepcionista repLoRe;
	    
	    
	    @GetMapping("/LogueoRecepcionista")
	    public String validarLogueo(@RequestParam String usuarioRecep, @RequestParam String passwordRecep) {
	        loguin_Recepcionista login = repLoRe.findByUsuarioRecepAndPasswordRecep(usuarioRecep, passwordRecep);

	        if (login != null) {
	 
	            recepcionista recep = login.getIDRecepcionista();
	            
	            // Guarda el objeto logueado
	            recepLogueado = recep;

	            // Recupera y devuelve el rol
	            String rol = recep.getRolRecepcionista();
	            return rol; 
	        }
	        
	        return "Credenciales incorrectas";
	    }
	    
	    
	    @GetMapping("/CerrarSesion")
	    public String CerrarSesion(){
	    	
	    	recepLogueado = null;
	    	return "Sesión cerrada correctamente";
	    	
	    }
}
