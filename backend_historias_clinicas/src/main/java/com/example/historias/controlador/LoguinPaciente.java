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
import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.paciente;



@RestController
@RequestMapping("/loguin/Paciente")
public class LoguinPaciente {
    
    public paciente usu;

    @Autowired
    private in_Loguin_Paciente loguinPacienteRepo;

    @GetMapping("/Logueopaciente")
    public String validarLogueo(@RequestParam String usuarioPaciente, @RequestParam String password) {
        loguin_Paciente usuario = loguinPacienteRepo.findByUsuarioPacienteAndPassword(usuarioPaciente, password);
        if (usuario != null) {
            paciente usua = usuario.getIDpaciente();
            usu = usua;

            String rol = usua.getRolPaciente();
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


    @GetMapping("/cerrarSesionPaciente")
    public String cerrarSesion() {
        usu = null;
        return "sesion cerrada correctamente";
    }
}
