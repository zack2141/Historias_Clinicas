package com.example.historias.controlador;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.In_Medico;
import com.example.historias.modelo.medico;


@RestController
@RequestMapping("http://localhost:8080/Medico")

public class Medico {
	@Autowired
    private In_Medico medicoRepositorio;
	
	@GetMapping("/medicoDisponibles")
    public List<medico> listaMedicosDisponibles(
            @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha,
            @RequestParam("hora") @DateTimeFormat(pattern = "HH:mm") LocalTime Hora,
            @RequestParam("cargo") String cargoMedico
    ) {
        return medicoRepositorio.medicosDisponibles(Hora, Fecha, cargoMedico);
    }
}
