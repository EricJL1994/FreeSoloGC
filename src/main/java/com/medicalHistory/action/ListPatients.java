package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ListPatients {

    private final DoctorRepository doctorRepository;

    @Autowired
    public ListPatients(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Collection<Patient> of(Doctor doctor) {
        Doctor persistedDoctor = doctorRepository.findOne(doctor.getId());
        return persistedDoctor.getPatients();
    }
}
