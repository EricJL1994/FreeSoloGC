package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LoginShould {

    private String email;
    private String password;
    private HttpSession httpSession;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Before
    public void setUp() throws Exception {
        email = "email@company.com";
        password = "dont_look_at_this_its_secret";
        httpSession = mock(HttpSession.class);
        doctorRepository = mock(DoctorRepository.class);
        patientRepository = mock(PatientRepository.class);
    }

    @Test
    public void add_doctor_to_httpSession_if_exists_doctor_with_email_and_password_is_correct() {
        Doctor doctor = givenADoctor();
        when(doctorRepository.findByEmail(email)).thenReturn(doctor);

        boolean logged = new Login(doctorRepository, patientRepository).execute(httpSession, email, password, "doctor");

        verify(httpSession).setAttribute("user", doctor);
        assertThat(logged).isTrue();
    }

    @Test
    public void do_not_add_doctor_to_httpSession_if_password_is_incorrect() {
        String wrongPassword = "I dont know my password";
        Doctor doctor = givenADoctor();
        when(doctorRepository.findByEmail(email)).thenReturn(doctor);

        boolean logged = new Login(doctorRepository, patientRepository).execute(httpSession, email, wrongPassword, "doctor");

        verifyZeroInteractions(httpSession);
        assertThat(logged).isFalse();
    }

    @Test
    public void do_not_add_doctor_to_httpSession_if_there_is_not_any_doctor_with_such_email() {
        when(doctorRepository.findByEmail(email)).thenReturn(null);

        Boolean logged = new Login(doctorRepository, patientRepository).execute(httpSession, email, password, "doctor");

        verifyZeroInteractions(httpSession);
        assertThat(logged).isFalse();
    }

    private Doctor givenADoctor() {
        Doctor doctor = new Doctor();
        doctor.setEmail(email);
        doctor.setPassword(password);
        return doctor;
    }
}
