package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignPatientToDoctor {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AssignPatientToDoctor(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void execute(Long patientId, Long doctorId) {
        Doctor doctor = this.doctorRepository.findOne(doctorId);
        Patient patient = this.patientRepository.findOne(patientId);

        doctor.addPatient(patient);
        patient.addDoctor(doctor);

        this.doctorRepository.saveAndFlush(doctor);
        this.patientRepository.saveAndFlush(patient);
    }
}
