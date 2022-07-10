package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.DTO.OdontologoDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService iOdontologoService;

    @Test
    public void testCrearOdontologo() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Jose");
        odontologoDTO.setApellido("Ranieri");
        iOdontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoNahuel = iOdontologoService.leerOdontologo(1L);
        assertTrue(odontologoNahuel != null);

    }
}