package com.jsp.hospital_management.service;

import java.util.List;
import com.jsp.hospital_management.mapper.SymptomToSpecialityMapper;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management.entity.Doctor;
import com.jsp.hospital_management.entity.Patient;
import com.jsp.hospital_management.entity.Speciality;
import com.jsp.hospital_management.repository.DoctorRepository;
import com.jsp.hospital_management.repository.PatientRepository;

@Service
public class SuggestionService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    private final List<String> allowedCities = List.of("Delhi", "Noida", "Faridabad");

    public String suggestDoctor(Long patientId) {
        Optional<Patient> optionalPatient = patientRepo.findById(patientId);
        if (optionalPatient.isEmpty()) {
            return "Patient not found";
        }

        Patient patient = optionalPatient.get();

        if (!allowedCities.contains(patient.getCity())) {
            return "We are still waiting to expand to your location";
        }

        Speciality requiredSpeciality = SymptomToSpecialityMapper.getSpeciality(patient.getSymptom());

        List<Doctor> doctors = doctorRepo.findByCityAndSpeciality(patient.getCity(), requiredSpeciality);

        if (doctors.isEmpty()) {
            return "There isn’t any doctor present at your location for your symptom";
        }

        return doctors.toString();
    }
}
