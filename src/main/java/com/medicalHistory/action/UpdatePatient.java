package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;

public class UpdatePatient {

    private PatientRepository patientRepository;

    public UpdatePatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void execute(long id, Patient patient) {
        patient.setId(id);
        patientRepository.save(patient);
    }
}
