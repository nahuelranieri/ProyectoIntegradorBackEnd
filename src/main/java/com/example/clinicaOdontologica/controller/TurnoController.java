package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.DTO.TurnoDTO;
import com.example.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService iTurnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        iTurnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id){
        return iTurnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        iTurnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTurno(@PathVariable Long id){
        iTurnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK + ". El Turno con el id:" + id + " ha sido eliminado con exito.");
    }

    @GetMapping
    public Collection<TurnoDTO> listarTodosTurnos(){
        return iTurnoService.getTodos();
    }
}
