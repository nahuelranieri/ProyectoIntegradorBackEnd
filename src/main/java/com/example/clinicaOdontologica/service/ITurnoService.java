package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.DTO.TurnoDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException;
    TurnoDTO leerTurno(Long id) throws ResourceNotFoundException;
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id) throws ResourceNotFoundException;
    Set<TurnoDTO> getTodos();
}
