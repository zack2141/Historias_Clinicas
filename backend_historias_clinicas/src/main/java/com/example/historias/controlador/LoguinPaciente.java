package com.example.historias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.in_Loguin_Paciente;
import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.paciente;



@RestController
@RequestMapping("/Loguin")
@CrossOrigin(origins = "http://localhost:4200/")

public class LoguinPaciente {
    
    public loguin_Paciente usu;

    @Autowired
    private in_Loguin_Paciente loguinPacienteRepo;

    @GetMapping("/LogueoPaciente")
    public String validarLogueo(@RequestParam String usuarioPaciente, @RequestParam String password) {
        loguin_Paciente usuario = loguinPacienteRepo.findByUsuarioPacienteAndPassword(usuarioPaciente, password);
        if (usuario != null) {
            usu = usuario;
           

            String rol = usu.getIDpaciente().getRolPaciente();
            return rol;

        } else {
            return "usuario o contraseña incorrectos";
        }
    }

    public boolean crear_usuario(loguin_Paciente usuario) {
        if (loguinPacienteRepo.findByUsuarioPaciente(usuario.getUsuarioPaciente()) != null) {
            return false;
        }
        loguinPacienteRepo.save(usuario);
        return true;
    }


    @GetMapping("/cerrarSesion")
    public String cerrarSesion() {
        usu = null;
        return "sesion cerrada correctamente";
    }
    
    @GetMapping ("/obtener")
    private loguin_Paciente devuelvePaciente() {
    	return this.usu;
    }
}
