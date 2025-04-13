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

	    /*@Autowired
	    private in_Loguin_Paciente repLoPa;

	    @Autowired
	    //private conLoginPaciente conLoPa;

	    Registro de Paciente
	    @PostMapping("/RegistroPaciente")
	    public boolean registrarPaciente(@RequestBody paciente nuevo, @RequestParam String usuarioPaciente) {
	        if (repPa.existsById(nuevo.getIDpaciente()) || repPa.findByCorreo(nuevo.getCorreo()) != null) {
	            return false;
	        }

	        repPa.save(nuevo);

	        loguin_Paciente nuevoLogin = new loguin_Paciente(usuarioPaciente, nuevo.getPassword(), nuevo);
	        return conLoPa.crear_usuario(nuevoLogin);
	    }*/

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



	   