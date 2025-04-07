package com.example.historias.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historias.modelo.historia_Clinica;

public interface in_Historia_Clinica extends JpaRepository<historia_Clinica, Long> {

}
