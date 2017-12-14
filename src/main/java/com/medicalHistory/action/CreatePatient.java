package com.medicalHistory.action;

import com.medicalHistory.infrastructure.HistoryRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.History;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CreatePatientService")
public class CreatePatient {

    private final PatientRepository patientRepository;
    private final HistoryRepository historyRepository;

    @Autowired
    public CreatePatient(PatientRepository patientRepository, HistoryRepository historyRepository) {
        this.patientRepository = patientRepository;
        this.historyRepository = historyRepository;
    }

    public void execute(Patient patient) throws Exception {
        if (patientRepository.findByEmail(patient.getEmail()) != null) {
            throw new Exception();
        }
        patient.setHistory(createAHistory());
        this.patientRepository.saveAndFlush(patient);
    }

    private History createAHistory() {
        return historyRepository.saveAndFlush(new History());
    }
}