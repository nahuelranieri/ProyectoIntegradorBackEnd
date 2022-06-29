package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository <Paciente, Long> {
}
