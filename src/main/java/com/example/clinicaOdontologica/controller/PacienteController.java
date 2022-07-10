package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.DTO.PacienteDTO;
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
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id){
        return iPacienteService.leerPaciente(id);
    }

    @GetMapping
    public Collection<PacienteDTO> listarTodosPacientes(){
        return iPacienteService.getTodos();
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK );
    }

    @PutMapping("/{id}")
    public modificarPaciente(@PathVariable Long id){
        iPacienteService.modificarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Long id){
        iPacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK + ". El paciente con el id:" + id + " ha sido eliminado con exito.");
    }





}
