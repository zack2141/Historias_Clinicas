package com.example.historias.controlador;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.example.historias.modelo.loguin_Recepcionista;

@RestController
@RequestMapping("/Cita/")
@CrossOrigin(origins = "http://localhost:8080/")

public class Cita_Controlador {
	
	@Autowired
	private in_Cita repCi;
	
	@Autowired
	private in_Paciente repPA;
	
	@Autowired
	private In_Medico repME;
	
	@Autowired
	private conLoguinPaciente conLoPa;// para acceder a los metodos del controlador de LoguinPaciente
	
	
	@GetMapping("verCita")
	public List<cita>verCita(){
		return this.repCi.findAll();
		
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
	
	
	
	/*@GetMapping("agendarCita")
	public boolean agendarCita(
			@RequestParam ("fechai") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha,
			@RequestParam String hora,
			@RequestParam Long motivo,
			@RequestParam String medico,
			@RequestParam String paci) {
		
		loguin_Recepcionista Lrecepcionista= this.Loginrecep.logueado;
		
		recepcionista recep = this.repRec.findByLoguin_Recepcionista(Lrecepcionista);
		paciente paci=this.repPA.findById(paciente);
				
		
		cita nuevo= new cita(motivo,fecha,hora,paci,medi,)
		
	}
			
	(Long motivoCita, Date fecha, 
	 * LocalTime hora, paciente iDpaciente, medico iDmedico,
			recepcionista iDrecepcionista) {*/
}
