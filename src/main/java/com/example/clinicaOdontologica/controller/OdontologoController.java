package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService;
    //Utilizo la inyeccion por constructor en vez del @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public Odontologo crearOdontologo(@RequestBody Odontologo o){
        return odontologoService.crear(o);
    }

    @PostMapping
    public List<Odontologo> listarOdontologos(){
        return odontologoService.listar();
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable Long id){
        return odontologoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminar(id);
        return "¡Odontologo Eliminado!";
    }
}
