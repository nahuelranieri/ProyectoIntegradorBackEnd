package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository <Odontologo, Long> {
}
