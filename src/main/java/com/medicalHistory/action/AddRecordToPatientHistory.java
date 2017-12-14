package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.infrastructure.RecordRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import com.medicalHistory.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRecordToPatientHistory {

    private final PatientRepository patientRepository;
    private final RecordRepository recordRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AddRecordToPatientHistory(PatientRepository patientRepository, RecordRepository recordRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.recordRepository = recordRepository;
        this.doctorRepository = doctorRepository;
    }

    public void execute(Long patientId, Doctor doctor, Record deserializedRecord) {
        Patient patient = patientRepository.findOne(patientId);
        Doctor fromRepo = doctorRepository.findOne(doctor.getId());
        deserializedRecord.setDoctor(fromRepo);
        deserializedRecord.setHistory(patient.getHistory());
        Record persistedRecord = recordRepository.saveAndFlush(deserializedRecord);
        patient.addRecordToHistory(persistedRecord);

        patientRepository.saveAndFlush(patient);
    }
}
