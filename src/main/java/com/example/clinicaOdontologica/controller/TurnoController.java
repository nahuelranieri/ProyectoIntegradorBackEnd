package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.DTO.TurnoDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService iTurnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException{
        iTurnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok("Turno asignado correctamente");
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id) throws ResourceNotFoundException{
        return iTurnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        iTurnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarTurno(@PathVariable Long id) throws ResourceNotFoundException{
        iTurnoService.eliminarTurno(id);
        return ResponseEntity.ok("El Turno con el id:" + id + " ha sido eliminado con exito.");
    }

    @GetMapping
    public Collection<TurnoDTO> listarTodosTurnos(){
        return iTurnoService.getTodos();
    }
}
