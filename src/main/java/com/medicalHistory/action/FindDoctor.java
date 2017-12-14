package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FindDoctor {
    private DoctorRepository doctorRepository;

    @Autowired
    public FindDoctor(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> execute(String doctorName) {
        return doctorRepository.findByName(doctorName);
        //TODO hacer que encuentre no solo si coincide el nombre completo, también parcialmente.
    }
}
