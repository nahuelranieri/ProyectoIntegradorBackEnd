package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService iPacienteService;

    @PostMapping
    public ResponseEntity<String> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        iPacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("Paciente creado con exito");
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id) throws ResourceNotFoundException{
        return iPacienteService.leerPaciente(id);
    }

    @GetMapping
    public Collection<PacienteDTO> listarTodosPacientes()  {
        return iPacienteService.getTodos();
    }

    @PutMapping
    public ResponseEntity<String> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        iPacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok("Paciente modificado con exito.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        iPacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("El paciente con el id:" + id + " ha sido eliminado con exito.");
    }





}
