package com.medicalHistory.action;

import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Patient;
import com.medicalHistory.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShowHistoryOfPatient {

    private final PatientRepository patientRepository;

    @Autowired
    public ShowHistoryOfPatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Collection<Record> execute(Long patientId) {
        Patient patient = patientRepository.findOne(patientId);
        return patient.getHistoryRecords();
    }
}
