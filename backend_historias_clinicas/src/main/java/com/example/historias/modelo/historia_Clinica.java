package com.example.historias.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity  
@Table(name ="Historia_Clinica")
public class historia_Clinica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Historial")
	private Long IDhistorial;
	
	@Column(name="Receta_Medicamentos")
	private String recetaMedicamentos;
	
	@Column(name="Motivo_Cita")
	private String motivoCita;
	
	@Column(name="Enfermedad_Paciente")
	private String enfermedadPaciente;
	
	@Column(name="Tratamientos")
	private String Tratamientos;
	
	@Column(name="Observaciones")
	private String observaciones;
	
	@Column(name="Examenes_Complementarios")
	private String examenesComplementario;
	
	@Column(name="Diagnosticos")
	private String diagnosticos;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Paciente", referencedColumnName = "ID_Paciente")
	private paciente IDpaciente;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Medico", referencedColumnName = "ID_Medico")
	private medico IDmedico;

	public historia_Clinica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public historia_Clinica(String recetaMedicamentos, String motivoCita, String enfermedadPaciente,
			String tratamientos, String observaciones, String examenesComplementario, String diagnosticos,
			paciente iDpaciente, medico iDmedico) {
		super();
		this.recetaMedicamentos = recetaMedicamentos;
		this.motivoCita = motivoCita;
		this.enfermedadPaciente = enfermedadPaciente;
		Tratamientos = tratamientos;
		this.observaciones = observaciones;
		this.examenesComplementario = examenesComplementario;
		this.diagnosticos = diagnosticos;
		IDpaciente = iDpaciente;
		IDmedico = iDmedico;
	}

	public Long getIDhistorial() {
		return IDhistorial;
	}

	public void setIDhistorial(Long iDhistorial) {
		IDhistorial = iDhistorial;
	}

	public String getRecetaMedicamentos() {
		return recetaMedicamentos;
	}

	public void setRecetaMedicamentos(String recetaMedicamentos) {
		this.recetaMedicamentos = recetaMedicamentos;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public String getEnfermedadPaciente() {
		return enfermedadPaciente;
	}

	public void setEnfermedadPaciente(String enfermedadPaciente) {
		this.enfermedadPaciente = enfermedadPaciente;
	}

	public String getTratamientos() {
		return Tratamientos;
	}

	public void setTratamientos(String tratamientos) {
		Tratamientos = tratamientos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getExamenesComplementario() {
		return examenesComplementario;
	}

	public void setExamenesComplementario(String examenesComplementario) {
		this.examenesComplementario = examenesComplementario;
	}

	public String getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(String diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public paciente getIDpaciente() {
		return IDpaciente;
	}

	public void setIDpaciente(paciente iDpaciente) {
		IDpaciente = iDpaciente;
	}

	public medico getIDmedico() {
		return IDmedico;
	}

	public void setIDmedico(medico iDmedico) {
		IDmedico = iDmedico;
	}
	
	

}
