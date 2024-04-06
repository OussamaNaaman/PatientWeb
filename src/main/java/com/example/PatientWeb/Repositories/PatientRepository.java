package com.example.PatientWeb.Repositories;

import com.example.PatientWeb.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findByNomContaining(String nom, Pageable pageable);
}
