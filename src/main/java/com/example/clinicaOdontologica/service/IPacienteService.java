package com.example.clinicaOdontologica.service;


import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException;
    PacienteDTO leerPaciente(Long id) throws ResourceNotFoundException;
    void modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException;
    void eliminarPaciente(Long id) throws ResourceNotFoundException;
    Set<PacienteDTO> getTodos();
}
