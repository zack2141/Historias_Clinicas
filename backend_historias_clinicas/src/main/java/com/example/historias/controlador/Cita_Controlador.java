package com.example.historias.controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.historias.interfaces.In_Medico;
import com.example.historias.interfaces.in_Cita;
import com.example.historias.interfaces.in_Paciente;
import com.example.historias.modelo.cita;
import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.medico;
import com.example.historias.modelo.paciente;
import com.example.historias.modelo.recepcionista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import com.example.historias.modelo.loguin_Recepcionista;

@RestController
@RequestMapping("/Cita/")
@CrossOrigin(origins = "http://localhost:8080/")

public class Cita_Controlador {
	
    @PersistenceContext
     private EntityManager entityManager;
    
	@Autowired
	private in_Cita repCi;
	
	@Autowired
	private in_Paciente repPA;
	
	@Autowired
	private In_Medico repME;
	
	@Autowired
	private conPaciente conLoPa;// para acceder a los metodos del controlador de LoguinPaciente//
	
	@Autowired
	private conLoguinRecepcionista conLoRe;
	
	@Autowired
	private  Medico conLoMe;

	@GetMapping("verCita")
	public List<cita>verCita(){
		return this.repCi.findAll();
		
	}
	
	@GetMapping("/agendarCitaPaciente")
	public boolean agendarCitaPaciente(
	        @RequestParam Long motivo,
	        @RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha,
	        @RequestParam String hora,
	        @RequestParam Long estado, 
	        @RequestParam Long medicoId) {
	
	loguin_Paciente loguin_paciente = this.conLoPa.pacienteLogueado;
		
		paciente paci = loguin_paciente.getIDpaciente();
		
	    Optional<medico> medicoOptional = this.repME.findById(medicoId);
	    if (!medicoOptional.isPresent()){
	   return false;
	   }
	    medico med = medicoOptional.get();
	    
	    // Crear y guardar la nueva cita (el estado lo podés mapear si es numérico)
	    cita nuevaCita = new cita(motivo, fecha, hora, "asignada", paci, med, null);
	    this.repCi.save(nuevaCita);

	    return true;
	}

	
	@GetMapping("/agendarCitaRecep")
	public boolean agendarCitaRecep(
	    @RequestParam Long motivo,
	    @RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha,
	    @RequestParam String hora,
	    @RequestParam Long estado, 
	    @RequestParam Long idMedico, 
	    @RequestParam Long idPaciente
	) {
	    // Obtener al recepcionista logueado
	    recepcionista recep = this.conLoRe.recepLogueado;

	    if (recep == null) {
	        return false; // no hay recepcionista logueado
	    }

	     /*recep.getIDrecepcionista();*/

	    // Buscar al médico y paciente por ID
	    Optional<medico> medicoOptional = this.repME.findById(idMedico);
	    Optional<paciente> pacienteOptional = this.repPA.findById(idPaciente);

	    // Validar que el médico y el paciente existen
	    if (!medicoOptional.isPresent() || !pacienteOptional.isPresent()) {
	        return false;
	    }

	    medico med = medicoOptional.get();
	    paciente pac = pacienteOptional.get();

	    // Crear y guardar la nueva cita (el estado lo podés mapear si es numérico)
	    cita nuevaCita = new cita(motivo, fecha, hora, "asignada", pac, med, recep);
	    this.repCi.save(nuevaCita);

	    return true;
	}
	
	@GetMapping("citasProximas")
	public List<cita>citasProximas(){
		
		loguin_Paciente loguin_paciente = this.conLoPa.pacienteLogueado;
		
		paciente paci = loguin_paciente.getIDpaciente();
		
		return this.repCi.findByPacienteAndEstadoCi(paci,"pendiente");
		
		}
	
	@GetMapping("citasSolicitadas")
	public List<cita>citasSolicitadas(){
		
		loguin_Paciente loguin_paciente = this.conLoPa.pacienteLogueado;
		
		paciente paci = loguin_paciente.getIDpaciente();
		
		return this.repCi.findByPacienteAndEstadoCi(paci,"asignada");
		
		}
	
	@GetMapping("cancelarCita")
	public boolean cancelarCita(
			@RequestParam Long id) {
		
		cita citita=this.repCi.findById(id);
		
		citita.setEstado("cancelada");
		
		this.repCi.save(citita);
		
		return true;
				
	}
	
	@GetMapping("/ListaPacientes")
	public List<cita> verListaPacientes(
	        @RequestParam Long medicoId,
	        @RequestParam("fecha1") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha) {

	    // Buscar al médico por ID
	    Optional<medico> medicoOptional = this.repME.findById(medicoId);

	    if (!medicoOptional.isPresent()) {
	        return new ArrayList<>(); // Retorna lista vacía si el médico no existe
	    }

	    medico med = medicoOptional.get();

	    // Obtener las citas por médico y fecha
	    List<cita> citas = this.repCi.findByIdmedicoAndFecha(med, fecha);

	    return citas;
	}
	
	@GetMapping("ListaPacientes")
	public List<paciente>ListaPacientes(){
		
		
		return this.repPA.findAll();
	
    }
	
	
	@GetMapping("IngresoPaciente")
	public boolean IngresarPaciente(
			@RequestParam Long id) {
		
		cita ingreso=this.repCi.findById(id);
		
		ingreso.setEstado("ingresado");
		
		this.repCi.save(ingreso);
		
		return true;
				
	}
	
	@GetMapping("asistenciaPaciente")
	public boolean asistenciaPaciente(
			@RequestParam Long id) {
		
		cita asistencia=this.repCi.findById(id);
		
		asistencia.setEstado("atendido");
		
		this.repCi.save(asistencia);
		
		return true;
				
	}
	
	@GetMapping("citasdelDia")
	public List<cita> citasDeHoy() {
	    return this.repCi.citasDelDia();
	}
	

	
	@GetMapping("/citasunDia")
	public List<cita> citasPorFecha(
		    @RequestParam("fechai") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha
		) {
		    return this.repCi.findByFecha(fecha);
		}

	
	@GetMapping("/citasPaciente")
	public List<cita> verCitaspaciente(
	    @RequestParam("fecha1") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha,
	    @RequestParam Long idpaciente
	) {
	    // Obtenemos todas las citas de esa fecha
	    List<cita> citasDeLaFecha = this.repCi.findByFecha(fecha);

	    // Filtramos solo las que pertenecen al paciente solicitado
	    return citasDeLaFecha.stream()
	        .filter(c -> c.getIDpaciente().getIDpaciente().equals(idpaciente))
	        .collect(Collectors.toList());
	}
	
	

	}
