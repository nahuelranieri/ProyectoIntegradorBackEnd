package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    void crearTurno(Turno turno);
    Optional<Turno> leerTurno(Long id);
    void modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    List<Turno> getTodos();
}
