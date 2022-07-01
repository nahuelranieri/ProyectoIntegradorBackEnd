package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.repository.ITurnoRepository;

public class TurnoService {

    private ITurnoRepository iTurnoRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired

    public TurnoService(ITurnoRepository iTurnoRepository) {
        this.iTurnoRepository = iTurnoRepository;
    }
}
