package com.example.clinicaOdontologica.security;

import com.example.clinicaOdontologica.model.AppUser;
import com.example.clinicaOdontologica.model.AppUsuarioRoles;
import com.example.clinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("Nahuel","nahue","nahue@gmail.com", password, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Nicolas","nico","nico@gmail.com", password2, AppUsuarioRoles.USER));
    }
}
