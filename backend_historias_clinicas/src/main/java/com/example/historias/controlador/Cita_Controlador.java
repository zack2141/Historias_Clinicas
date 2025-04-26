package com.example.historias.controlador;

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
import com.example.historias.interfaces.in_Loguin_Paciente;
import com.example.historias.interfaces.in_Paciente;
import com.example.historias.modelo.cita;
import com.example.historias.modelo.loguin_Paciente;
import com.example.historias.modelo.medico;
import com.example.historias.modelo.paciente;
import com.example.historias.modelo.recepcionista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RestController
@RequestMapping("/Cita/")
@CrossOrigin(origins = "http://localhost:4200/")

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
	private in_Loguin_Paciente repLoPa;
	
	@Autowired
	private LoguinPaciente conLoPa;// para acceder a los metodos del controlador de LoguinPaciente//
	
	@Autowired
	private conLoguinRecepcionista conLoRe;
	
	@Autowired
	private  LoguinMedico conLoMe;

	@GetMapping("verCita")
	public List<cita>verCita(){
		return this.repCi.findAll();
		
	}
	
	@GetMapping("/agendarCitaPaciente")
	public boolean agendarCitaPaciente(
	        @RequestParam String motivo,
	        @RequestParam("Fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
	        @RequestParam String hora,
	        @RequestParam ("medico")Long idMedico) {

		loguin_Paciente paci = this.conLoPa.usu;

	    Optional<medico> medicoOptional = this.repME.findById(idMedico);
	    if (!medicoOptional.isPresent()) {
	        return false;
	    }

	    medico med = medicoOptional.get();

	    cita nuevaCita = new cita(motivo, "Asignada", fecha, hora, paci.getIDpaciente(), med, null);
	    this.repCi.save(nuevaCita);

	    return true;
	}


	
	@GetMapping("/agendarCitaRecep")
	public boolean agendarCitaRecep(
	    @RequestParam String motivo,
	    @RequestParam("Fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
        @RequestParam String hora,
        @RequestParam ("medico")Long idMedico,
        @RequestParam ("paciente")Long idpaciente
	) {
		
		Optional<medico> medicoOptional = this.repME.findById(idMedico);
		 medico med = medicoOptional.get();
		
		 paciente paci =this.repPA.findById(idpaciente).get();
		 
		 recepcionista log = this.conLoRe.recepLogueado;
		 
		cita nuevaCita = new cita(motivo, "Asignada", fecha, hora, paci, med, log);
		
		this.repCi.save(nuevaCita);
	    
		return true;
	}
	
	@GetMapping("citasProximas")
	public List<cita>citasProximas(){
		
		paciente paci = this.conLoPa.usu.getIDpaciente();
		
	
		
		return this.repCi.findByIDpacienteAndEstado(paci,"Asignada");
		
		}
	
	@GetMapping("citasSolicitadas")
	public List<cita>citasSolicitadas(){
		
		paciente paci = this.conLoPa.usu.getIDpaciente();
		
		return this.repCi.findByIDpacienteAndEstado(paci,"Atendida");
		
		}
	
	@GetMapping("/cancelarCita")
	public boolean cancelarCita(
			@RequestParam Long id) {
		
		cita citita=this.repCi.findById(id).get();
		
		citita.setEstado("cancelada");
		
		this.repCi.save(citita);
		
		return true;
				
	}
	
	@GetMapping("/ListaPacientesPorFecha")
	public List<cita> verListaPacientes(
	    
	        @RequestParam("fecha1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {

	 
        medico medi = this.conLoMe.medic.getIDmedico();

	   

	    // Obtener las citas por médico y fecha
	    List<cita> citas = this.repCi.findByIDmedicoAndFecha(medi, fecha);

	    return citas;
	}
	
	@GetMapping("ListaPacientes")
	public List<paciente>ListaPacientes(){
		
		
		return this.repPA.findAll();
	
    }
	
	
	@GetMapping("IngresoPaciente")
	public boolean IngresarPaciente(
			@RequestParam Long id) {
		
		cita ingreso=this.repCi.findById(id).get();
		
		ingreso.setEstado("Ingresado");
		
		this.repCi.save(ingreso);
		
		return true;
				
	}
	
	@GetMapping("asistenciaPaciente")
	public boolean asistenciaPaciente(
			@RequestParam Long id) {
		
		cita asistencia=this.repCi.findById(id).get();
		
		asistencia.setEstado("Atendida");
		
		this.repCi.save(asistencia);
		
		return true;
				
	}
	
	@GetMapping("citasdelDia")
	public List<cita> citasDeHoy() {
	    return this.repCi.citasDelDia();
	}
	
	@GetMapping("citasdelDia2")
	public List<cita> citasDeHoy2() {
	    return this.repCi.citasDelDia2();
	}
	

	
	@GetMapping("/citasunDia")
	public List<cita> citasPorFecha(
		    @RequestParam("fechai") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha
		) {
		    return this.repCi.findByFecha(fecha);
		}

	
	@GetMapping("/citasPaciente")
	public List<cita> verCitaspaciente(
	    @RequestParam("fecha1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
	    @RequestParam String IDpaciente
	) {
	    // Obtenemos todas las citas de esa fecha
	    List<cita> citasDeLaFecha = this.repCi.findByFecha(fecha);
	    
	    paciente persona = this.repLoPa.findByUsuarioPaciente(IDpaciente).getIDpaciente();

	    
	    //Filtramos solo las que pertenecen al paciente solicitado
	    return citasDeLaFecha.stream()
	        .filter(c -> c.getIDpaciente().getIDpaciente().equals(persona.getIDpaciente()) && c.getEstado().equals("Asignada"))
	        .collect(Collectors.toList());
	    
	    
	}
	
	// cita repetida
	
	@GetMapping("/citarepetida")
	public boolean citarepedita (
			@RequestParam("Fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha ) {
		
		cita dato = this.repCi.findByIDpacienteAndFechaAndEstado(this.conLoPa.usu.getIDpaciente(), fecha,"Asignada");
		
		if(dato != null) {
			return true;
		}else {
			return false;
		}
		
	}
	

	}
