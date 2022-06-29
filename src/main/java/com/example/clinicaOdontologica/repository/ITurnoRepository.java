package com.example.clinicaOdontologica.repository;


import com.example.clinicaOdontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository <Turno, Long> {
}
