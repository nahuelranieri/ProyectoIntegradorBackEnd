package com.example.clinicaOdontologica.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Debido a que uso en el codigo SpringBoot 2.7.1, WebSecurityConfigurerAdapter viene por defecto
//Deprecado (Si lo aplicamos vemos como se tacha). Asi que en vez de hacer Override para configurar
//Http y (en nuestro caso) AutheticationManagerBuild, ahora declaramos dos beans, del tipo SecurityFilterChain
// y AuthenticationManager.
//Fuente https://codejava.net/frameworks/spring-boot/fix-websecurityconfigureradapter-deprecated#:~:text=The%20type%20WebSecurityConfigurerAdapter%20is%20deprecated,-So%2C%20why%20Spring&text=Well%2C%20it's%20because%20the%20developers,a%20component%2Dbased%20security%20configuration.


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    /*

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AppUserService userService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());

    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

 */



}
