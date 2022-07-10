package com.example.clinicaOdontologica.repository;


import com.example.clinicaOdontologica.DTO.TurnoDTO;
import com.example.clinicaOdontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository <Turno, Long> {
}
