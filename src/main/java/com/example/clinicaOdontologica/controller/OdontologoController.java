package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.DTO.OdontologoDTO;
import com.example.clinicaOdontologica.DTO.PacienteDTO;
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
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id){
        return iOdontologoService.leerOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologo(@PathVariable Long id){
        iOdontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK + ". El odontologo con el id:" + id + " ha sido eliminado con exito.");
    }

    @GetMapping
    public Collection<OdontologoDTO> listarTodosOdontologos(){
        return iOdontologoService.getTodos();
    }



}
