package com.jsp.hospital_management.mapper;

import com.jsp.hospital_management.entity.Speciality;
import com.jsp.hospital_management.entity.Symptom;

public class SymptomToSpecialityMapper {
    public static Speciality getSpeciality(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
        };
    }
}
