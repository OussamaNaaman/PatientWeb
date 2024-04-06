package com.example.PatientWeb.controller;

import com.example.PatientWeb.Entities.Patient;
import com.example.PatientWeb.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all")
    public String getAllPatients(Model model, Pageable pageable) {
        Page<Patient> patients = patientRepository.findAll(pageable);
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/search")
    public String searchPatients(Model model, @RequestParam("keyword") String keyword, Pageable pageable) {
        Page<Patient> patients = patientRepository.findByNomContaining(keyword, pageable);
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients/all";
    }
}
