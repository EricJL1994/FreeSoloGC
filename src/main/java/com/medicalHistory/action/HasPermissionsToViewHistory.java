package com.medicalHistory.action;

import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HasPermissionsToViewHistory {
    private final PatientRepository patientRepository;

    @Autowired
    public HasPermissionsToViewHistory(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public boolean execute(Object user, Long patientId) {
        if (user instanceof Doctor) {
            Patient patient = patientRepository.findOne(patientId);
            return patient.hasPermissionsToViewHistory((Doctor) user);
        }else if(user instanceof Patient){
            return ((Patient) user).hasId(patientId);
        }
        return false;
    }
}
