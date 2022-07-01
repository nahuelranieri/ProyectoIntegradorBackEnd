package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @PostMapping
    public Odontologo crearOdontologo(@RequestBody Odontologo o){
        return odontologoService.crear(o);
    }

    @PostMapping
    public List<Odontologo> listar(){
        return odontologoService.listar();
    }
    @GetMapping("/{id}")
    public Odontologo buscar(@PathVariable Long id){
        return odontologoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        odontologoService.eliminar(id);
        return "Odontologo Eliminado";
    }
}
