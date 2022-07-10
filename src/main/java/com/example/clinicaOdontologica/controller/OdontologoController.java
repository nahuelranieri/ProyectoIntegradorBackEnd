package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.DTO.OdontologoDTO;
import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.IOdontologoService;
import com.example.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService iOdontologoService;

    @PostMapping
    public ResponseEntity<String> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok("Odontologo creado con exito");
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id) throws ResourceNotFoundException{
        return iOdontologoService.leerOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        iOdontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("El odontologo con el id:" + id + " ha sido eliminado con exito.");
    }

    @GetMapping
    public Collection<OdontologoDTO> listarTodosOdontologos(){
        return iOdontologoService.getTodos();
    }



}
