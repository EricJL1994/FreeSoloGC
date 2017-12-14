package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class Login {
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public Login(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public boolean execute(HttpSession httpSession, String email, String password, String userType) {
        if (userType.equals("doctor")) {
            return logDoctor(httpSession, email, password);
        }
        return logPatient(httpSession, email, password);
    }

    private boolean logDoctor(HttpSession httpSession, String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor == null) return false;
        if (!doctor.isCorrectPassword(password)) return false;
        httpSession.setAttribute("user", doctor);
        return true;
        //TODO mejorar para que devuelva un doctor o un paciente
    }

    private boolean logPatient(HttpSession httpSession, String email, String password) {
        Patient patient = patientRepository.findByEmail(email);
        if (patient == null) return false;
        if (!patient.isCorrectPassword(password)) return false;
        httpSession.setAttribute("user", patient);
        return true;
    }
}
