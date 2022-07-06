package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.DTO.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO leerOdontologo(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> getTodos();

}
