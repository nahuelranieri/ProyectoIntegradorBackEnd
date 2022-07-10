package com.example.clinicaOdontologica.service;



import com.example.clinicaOdontologica.DTO.PacienteDTO;
import com.example.clinicaOdontologica.DTO.TurnoDTO;
import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.model.Turno;
import com.example.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository iTurnoRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired

    /*public TurnoService(ITurnoRepository iTurnoRepository) {
        this.iTurnoRepository = iTurnoRepository;
    }*/

    @Autowired
    ObjectMapper mapper;

    private void guardarTurno(TurnoDTO turnoDTO) {
        //el metodo save de PacienteRepository sirve tanto para crear desde 0, como para modificar.
        // Si id = 0 lo agrega como nuevo, si es diferente de 0 va a modificar el valor.
        //De esta manera reutilizo codigo
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);//Nos convierte odontologo dto a un objeto del tipo odontologo
        iTurnoRepository.save(turno);
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
        //iTurnoRepository.save(turnoDTO);
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
        //iTurnoRepository.save(turnoDTO);
    }

    @Override
    public TurnoDTO leerTurno(Long id) {
        Optional<Turno> turno = iTurnoRepository.findById(id);//con Optional<> podemos consultar si el objeto que nos devuelvo es o no null
        TurnoDTO turnoDTO = null;
        if(turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
        //return iTurnoRepository.findById(id);
    }

    @Override
    public void eliminarTurno(Long id) {
        iTurnoRepository.deleteById(id);

    }

    @Override
    public Set<TurnoDTO> getTodos() {
        //El List me devuelve una lista de pacientes donde cada objeto es del tipo Paciente pero yo
        //tengo que devolver un Set PERO con objetos PacienteDTO.
        List<Turno> turnos = iTurnoRepository.findAll();
        Set<TurnoDTO> turnoDTO = new HashSet<>();
        //Recorro la lista de pacientes de la coleccion de pacientes y lleno otro Set donde a cada uno de los
        //objetos paciente lo transformo en un PacienteDTO.
        for (Turno turno : turnos){
            turnoDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTO;
    }
}
