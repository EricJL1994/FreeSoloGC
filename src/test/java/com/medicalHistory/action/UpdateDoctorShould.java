package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.model.Doctor;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UpdateDoctorShould {

    @Test
    public void update_doctor() {
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        Doctor doctor = new Doctor();
        UpdateDoctor action = new UpdateDoctor(doctorRepository);
        long id = 12;

        action.execute(id, doctor);

        assertThat(doctor.getId()).isEqualTo(id);
        verify(doctorRepository).save(doctor);
    }
}
