package com.jsp.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital_management.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}