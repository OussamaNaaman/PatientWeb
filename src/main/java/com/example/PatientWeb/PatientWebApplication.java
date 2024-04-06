package com.example.PatientWeb;

import com.example.PatientWeb.Entities.Patient;
import com.example.PatientWeb.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class PatientWebApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientWebApplication.class, args);
    }

    @Override
    public void run(String... args) {
        patientRepository.save(new Patient(null, "samo", new Date(), true, 600));
        patientRepository.save(new Patient(null, "mohammed", new Date(), false, 905));
        patientRepository.save(new Patient(null, "fatima", new Date(), false, 1000));
        List<Patient> Patients = patientRepository.findAll();
        for (var e : Patients) {
            System.out.println(e);
        }
        ;
    }
}

