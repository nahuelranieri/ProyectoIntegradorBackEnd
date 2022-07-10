package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.DTO.OdontologoDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO leerOdontologo(Long id) throws ResourceNotFoundException;
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    Set<OdontologoDTO> getTodos();

}
