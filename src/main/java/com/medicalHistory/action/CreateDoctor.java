package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CreateDoctorService")
public class CreateDoctor {

    private final DoctorRepository doctorRepository;

    @Autowired
    public CreateDoctor(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void execute(Doctor doctor) throws Exception {
        if (doctorRepository.findByEmail(doctor.getEmail()) != null) {
            throw new Exception();
        }
        doctorRepository.saveAndFlush(doctor);
    }
}
