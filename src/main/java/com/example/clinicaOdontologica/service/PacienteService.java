package com.example.clinicaOdontologica.service;


import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.exceptions.GlobalExceptionHandler;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository iPacienteRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired
    /*
    public PacienteService(IPacienteRepository iPacienteRepository) {
        this.iPacienteRepository = iPacienteRepository;
    }
    */

    @Autowired
    ObjectMapper mapper;

    private void guardarPaciente(PacienteDTO pacienteDTO){
        //el metodo save de PacienteRepository sirve tanto para crear desde 0, como para modificar.
        // Si id = 0 lo agrega como nuevo, si es diferente de 0 va a modificar el valor.
        //De esta manera reutilizo codigo
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);//Nos convierte odontologo dto a un objeto del tipo odontologo
        iPacienteRepository.save(paciente);
    }


    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO)  {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) throws ResourceNotFoundException {
        //con Optional<> podemos consultar si el objeto que nos devuelvo es o no null
        Optional<Paciente> paciente = iPacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        else
            throw new ResourceNotFoundException("no existe un paciente con el id: " +id);
        return pacienteDTO;
    }



    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if(leerPaciente(id)==null)
            throw new ResourceNotFoundException("no existe un paciente con el id: " +id);
        iPacienteRepository.deleteById(id);

    }

    @Override
    public Set<PacienteDTO> getTodos() {
        //El List me devuelve una lista de pacientes donde cada objeto es del tipo Paciente pero yo
        //tengo que devolver un Set PERO con objetos PacienteDTO.
        List<Paciente> pacientes = iPacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTO = new HashSet<>();
        //Recorro la lista de pacientes de la coleccion de pacientes y lleno otro Set donde a cada uno de los
        //objetos paciente lo transformo en un PacienteDTO.
        for (Paciente paciente : pacientes){
            pacienteDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTO;
    }
}

