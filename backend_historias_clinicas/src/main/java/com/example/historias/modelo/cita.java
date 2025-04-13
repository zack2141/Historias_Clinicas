package com.example.historias.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "Cita")
public class cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Cita")
	private Long IDcita;
	
	@Column(name = "Motivo_Cita")
	private Long motivoCita;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yy")
	@Column(name = "Fecha")
	private Date Fecha;
	
	@JsonFormat(pattern = "HH:mm")
	@Column(name = "Hora")
	private LocalTime hora;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Paciente", referencedColumnName = "ID_Paciente")
	private paciente IDpaciente;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Medico", referencedColumnName = "ID_Medico")
	private medico IDmedico;
	
	@ManyToOne()
	@JoinColumn(name = "ID_Recepcionista", referencedColumnName = "ID_Recepcionista")
	private recepcionista IDrecepcionista;

<<<<<<< HEAD
    public cita() {}

	public cita(Long motivoCita, Date fecha, LocalTime hora, paciente iDpaciente, medico iDmedico,
=======
	public cita() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public cita(Long motivoCita, Date fecha, String hora, paciente iDpaciente, medico iDmedico,
>>>>>>> 2168c1b63f9b2167e0b300e9ed8095992fc09c65
			recepcionista iDrecepcionista) {
		super();
		this.motivoCita = motivoCita;
		Fecha = fecha;
		this.hora = hora;
		IDpaciente = iDpaciente;
		IDmedico = iDmedico;
		IDrecepcionista = iDrecepcionista;
	}
<<<<<<< HEAD
=======



	public Long getIDcita() {
		return IDcita;
	}

	public void setIDcita(Long iDcita) {
		IDcita = iDcita;
	}

	

	public Long getMotivoCita() {
		return motivoCita;
	}



	public void setMotivoCita(Long motivoCita) {
		this.motivoCita = motivoCita;
	}



	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

	public recepcionista getIDrecepcionista() {
		return IDrecepcionista;
	}

	public void setIDrecepcionista(recepcionista iDrecepcionista) {
		IDrecepcionista = iDrecepcionista;
	}





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cita")
    private Long idCita;


    @Column(name = "Motivo_Cita")
    private String motivoCita;

    @Column(name = "Estado")
    private String estado;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yy")
    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Hora")
    private String hora;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente", referencedColumnName = "ID_Paciente")
    private paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_Medico", referencedColumnName = "ID_Medico")
    private medico medico;

    @ManyToOne
    @JoinColumn(name = "ID_Recepcionista", referencedColumnName = "ID_Recepcionista")
    private recepcionista recepcionista;

    public cita() {}

    public cita(String motivoCita, String estado, Date fecha, String hora,
                paciente paciente, medico medico, recepcionista recepcionista) {
        this.motivoCita = motivoCita;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
        this.recepcionista = recepcionista;
    }
>>>>>>> 2168c1b63f9b2167e0b300e9ed8095992fc09c65

    // Getters y Setters
    public Long getIdCita() {
        return idCita;
    }

	public void setIDcita(Long iDcita) {
		IDcita = iDcita;
	}

	public Long getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(Long motivoCita) {
		this.motivoCita = motivoCita;
	}

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

    public paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(paciente paciente) {
        this.paciente = paciente;
    }

    public medico getMedico() {
        return medico;
    }

    public void setMedico(medico medico) {
        this.medico = medico;
    }

    public recepcionista getRecepcionista() {
        return recepcionista;
    }

	public void setIDrecepcionista(recepcionista iDrecepcionista) {
		IDrecepcionista = iDrecepcionista;
	}

}
