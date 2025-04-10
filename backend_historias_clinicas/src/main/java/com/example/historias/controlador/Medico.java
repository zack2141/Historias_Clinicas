package com.example.historias.controlador;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.historias.interfaces.In_Medico;
import com.example.historias.modelo.medico;

public class Medico {
	@Autowired
    private In_Medico medicoRepositorio;
	
	@GetMapping("/medicoDisponibles")
    public List<medico> listaMedicosDisponibles(
            @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam("hora") @DateTimeFormat(pattern = "HH:mm") LocalTime hora,
            @RequestParam("cargo") String cargoMedico
    ) {
        return medicoRepositorio.medicosDisponibles(hora, fecha, cargoMedico);
    }
}
