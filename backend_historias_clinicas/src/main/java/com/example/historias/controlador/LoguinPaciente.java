package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Loguin_Paciente;
import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.paciente;



@RestController
@CrossOrigin(origins = "http://localhost:8080/loguin/paciente")
public class LoguinPaciente {
	
	public paciente usu;

    @Autowired
    private in_Loguin_Paciente loguinPacienteRepo;

    @GetMapping("/Logueo")
    public String validarLogueo(@RequestParam String usuarioPaciente, @RequestParam String password) {
        loguin_Paciente usuario = loguinPacienteRepo.findByUsuarioPacienteAndPassword(usuarioPaciente, password);
        if (usuario != null) {
            paciente  usua= usuario.getIDpaciente();
            usu=usua;
            
            String rol =usua.getRolPaciente();
            return rol;
            
        } else {
            return "usuario o contraseña incorrectos";
        }
    }

    @PostMapping("/Crear_usuario")
    public String crearUsuario(@RequestBody loguin_Paciente usuarioPaciente) {
        if (loguinPacienteRepo.findByUsuarioPaciente(usuarioPaciente.getUsuarioPaciente()) != null) {
            return "el usuario ya existe";
        }
        loguinPacienteRepo.save(usuarioPaciente);
        return "usuario creado correctamente";
    }

    @GetMapping("/cerrarSesion")
    public String cerrarSesion() {
        usu = null;
        return "sesion cerrada correctamente";
    }
}

