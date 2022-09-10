package com.taxesejour.springproject3;

import com.taxesejour.springproject3.security.entities.AppRole;
import com.taxesejour.springproject3.security.entities.AppUser;
import com.taxesejour.springproject3.security.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringProject3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringProject3Application.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
  @Bean
    CommandLineRunner start(AppService appService){
        return args -> {
              /*appService.addNewAppUser(new AppUser("Osama","1234"));
            appService.addNewRole(new AppRole("USER"));
            appService.addRoleToUser("Osama","USER");
            appService.addNewRole(new AppRole("ADMIN"));
            appService.addRoleToUser("Osama","ADMIN");
            appService.addNewAppUser(new AppUser("Sada","1234"));*/
            appService.addRoleToUser("Yassine","USER");
        };
    };
}
