package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Turno;
import com.example.clinicaOdontologica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    private ITurnoRepository iTurnoRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired

    /*public TurnoService(ITurnoRepository iTurnoRepository) {
        this.iTurnoRepository = iTurnoRepository;
    }*/

    @Override
    public void crearTurno(Turno turno) {
        iTurnoRepository.save(turno);

    }

    @Override
    public Optional<Turno> leerTurno(Long id) {
        return iTurnoRepository.findById(id);
    }

    @Override
    public void modificarTurno(Turno turno) {
        iTurnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        iTurnoRepository.deleteById(id);

    }

    @Override
    public List<Turno> getTodos() {
        return iTurnoRepository.findAll();

    }
}
