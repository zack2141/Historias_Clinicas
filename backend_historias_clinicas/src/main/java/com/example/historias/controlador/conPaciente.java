package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/paciente")

public class conPaciente {
	
	    @Autowired
	    private in_Paciente repPa;

	    @Autowired
	    private in_Loguin_Paciente repLoPa;


	    @PostMapping("/registrar")
	    public boolean registrarPacienteConLogin(
	    		@RequestBody paciente nuevoPaciente, 
	            @RequestParam String usuario, 
	            @RequestParam String password) {
	    	
	        // Validar campos obligatorios
	        if (nuevoPaciente.getCorreo() == null || nuevoPaciente.getNombres() == null ||
	            nuevoPaciente.getApellidos() == null || usuario == null || password == null) {
	            return false;
	        }                             

	        // Verificar si el correo o el usuario ya existen
	        if (repPa.findByCorreo(nuevoPaciente.getCorreo()) != null || 
	            repLoPa.findByUsuarioPaciente(usuario) != null) {
	            return false;
	        }

	        // Guardar paciente
	        paciente pacienteGuardado = repPa.save(nuevoPaciente);

	        // Crear login y guardar
	        loguin_Paciente login = new loguin_Paciente(usuario, password, pacienteGuardado);
	        repLoPa.save(login);

	        return true;
	    }

	    //Actualizar Paciente
	    @PostMapping("/ActualizarPaciente")
	    public boolean actualizaPaciente(@RequestBody paciente act) {
	        if (!repPa.existsById(act.getIDpaciente())) return false;

	        String correoExistente = repPa.findByCorreo(act.getCorreo());
	        if (correoExistente != null && !act.getCorreo().equals(correoExistente)) {
	            return false;
	        }

	        repPa.save(act);
	        return true;
	    }

	    //Obtener datos del paciente
	    @GetMapping("/ObtenerPaciente")
	    public paciente verPaciente(@RequestParam Long id) {
	        return repPa.findById(id).orElse(null);
	    }
}



	   