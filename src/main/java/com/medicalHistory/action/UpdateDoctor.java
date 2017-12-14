package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.model.Doctor;

public class UpdateDoctor {

    private DoctorRepository doctorRepository;

    public UpdateDoctor(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void execute(long id, Doctor doctor) {
        doctor.setId(id);
        doctorRepository.save(doctor);
    }
}
