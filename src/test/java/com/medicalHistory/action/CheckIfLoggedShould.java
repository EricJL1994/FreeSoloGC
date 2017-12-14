package com.medicalHistory.action;

import com.medicalHistory.model.Doctor;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckIfLoggedShould {

    @Test
    public void return_true_when_user_is_logged() {
        HttpSession httpSession = mock(HttpSession.class);
        Doctor doctor = mock(Doctor.class);
        when(httpSession.getAttribute("user")).thenReturn(doctor);

        boolean logged = new CheckIfLogged().execute(httpSession);

        assertThat(logged).isTrue();
    }

    @Test
    public void return_false_when_user_is_not_logged() {
        HttpSession httpSession = mock(HttpSession.class);

        boolean logged = new CheckIfLogged().execute(httpSession);

        assertThat(logged).isFalse();
    }
}
