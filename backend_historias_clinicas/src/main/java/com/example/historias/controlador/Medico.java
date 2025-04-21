package com.example.historias.controlador;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.In_Medico;
import com.example.historias.modelo.medico;


@RestController
@RequestMapping("/Medico")
@CrossOrigin(origins = "http://localhost:4200/")

public class Medico {
	
	@Autowired
    private In_Medico medicoRepositorio;
	
	@GetMapping("/medicosDisponibles")
    public List<medico> listaMedicosDisponibles(
            @RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") Date Fecha,
            @RequestParam("hora") String Hora,
            @RequestParam("cargo") String cargoMedico
    ) {
        return medicoRepositorio.medicosDisponibles(Hora, Fecha, cargoMedico);
    }
}
