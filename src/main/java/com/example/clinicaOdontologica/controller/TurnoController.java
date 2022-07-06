package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Turno;
import com.example.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService iTurnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody Turno turno){
        iTurnoService.crearTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Turno> getTurno(@PathVariable Long id){
        return iTurnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody Turno turno){
        iTurnoService.modificarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTurno(@PathVariable Long id){
        iTurnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public List<Turno> listarTurnos(){
        return iTurnoService.getTodos();
    }
}
