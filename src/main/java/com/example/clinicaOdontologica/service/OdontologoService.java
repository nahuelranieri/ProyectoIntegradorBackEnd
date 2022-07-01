package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {


    private IOdontologoRepository iOdontologoRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired
    public OdontologoService(IOdontologoRepository iOdontologoRepository) {
        this.iOdontologoRepository = iOdontologoRepository;
    }

    public Odontologo crear (Odontologo o){
        iOdontologoRepository.save(o);
        return o;
    }

    public Odontologo buscar (Long id){
        //En el caso de no se encuentre un odontologo con el id deseado se devuelve un nulo.
        return iOdontologoRepository.findById(id).orElseGet(null);

    }

    public List<Odontologo> listar(){
        return iOdontologoRepository.findAll();
    }

    public void eliminar (Long id){
        iOdontologoRepository.deleteById(id);
    }


}
