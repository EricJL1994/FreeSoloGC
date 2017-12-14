package com.medicalHistory.action;

import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPatient {
    private PatientRepository patientRepository;

    @Autowired
    public FindPatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> execute(String name){
        return patientRepository.findByName(name);
        //TODO hacer que encuentre no solo si coincide el nombre completo, también parcialmente.
    }
}
