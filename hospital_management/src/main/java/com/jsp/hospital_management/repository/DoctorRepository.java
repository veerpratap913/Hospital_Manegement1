package com.jsp.hospital_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital_management.entity.Doctor;
import com.jsp.hospital_management.entity.Speciality;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}


