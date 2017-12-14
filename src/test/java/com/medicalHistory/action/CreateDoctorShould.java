package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.model.Doctor;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateDoctorShould {

    @Test
    public void save_doctor_in_repository() {
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        Doctor doctor = new Doctor();
        CreateDoctor action = new CreateDoctor(doctorRepository);

        try {
            action.execute(doctor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(doctorRepository).saveAndFlush(doctor);
    }
}
