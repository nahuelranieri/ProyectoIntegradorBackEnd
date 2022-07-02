package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private IPacienteRepository iPacienteRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired
    public PacienteService(IPacienteRepository iPacienteRepository) {
        this.iPacienteRepository = iPacienteRepository;
    }

    public Paciente crear(Paciente p){

        iPacienteRepository.save(p);
        return p;
    }

    public Paciente buscar (Long id){

        return iPacienteRepository.findById(id).orElseGet(null);
    }

    public List<Paciente> listar(){

        return iPacienteRepository.findAll();
    }

    public void eliminar (Long id){

        iPacienteRepository.deleteById(id);
    }
}

