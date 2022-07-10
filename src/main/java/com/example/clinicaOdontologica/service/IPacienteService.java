package com.example.clinicaOdontologica.service;


import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Long id) throws ResourceNotFoundException;
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id) throws ResourceNotFoundException;
    Set<PacienteDTO> getTodos();
}
