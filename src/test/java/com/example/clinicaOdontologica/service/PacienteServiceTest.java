package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.model.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService iPacienteService;

    @Test
    void testCrearPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Nahuel");
        pacienteDTO.setApellido("Ranieri");
        iPacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteDTO1 = iPacienteService.leerPaciente(1L);
        assertTrue(pacienteDTO1 != null);

    }
}