package com.jsp.hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospital_management.entity.Doctor;
import com.jsp.hospital_management.entity.Patient;
import com.jsp.hospital_management.repository.DoctorRepository;
import com.jsp.hospital_management.repository.PatientRepository;
import com.jsp.hospital_management.service.SuggestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class HealthcareController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody @Valid Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody @Valid Patient patient) {
        return patientRepo.save(patient);
    }

    @GetMapping("/suggest-doctor/{patientId}")
    public ResponseEntity<?> suggestDoctor(@PathVariable Long patientId) {
        String result = suggestionService.suggestDoctor(patientId);
        return ResponseEntity.ok(result);
    }
}
