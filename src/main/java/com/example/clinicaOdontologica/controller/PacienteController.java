package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    //Utilizo la inyeccion por constructor en vez del @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente p){
        return pacienteService.crear(p);
    }

    @PostMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable Long id){
        return pacienteService.buscar(id);
    }

    @DeleteMapping("{/id}")
    public String eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminar(id);
        return "¡Paciente Eliminado!";
    }
}
