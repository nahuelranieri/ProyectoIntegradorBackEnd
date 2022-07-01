package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
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

    public void crearPaciente (Paciente p){
        iPacienteRepository.save(p);
    }

    public Paciente buscarPaciente (Long id){
        return iPacienteRepository.findById(id).orElseGet(null);
    }

    public List<Paciente> listarPaciente(){
        return iPacienteRepository.findAll();
    }

    public void eliminarPaciente (Long id){
        iPacienteRepository.deleteById(id);
    }
}

