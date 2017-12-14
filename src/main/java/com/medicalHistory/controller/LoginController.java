package com.medicalHistory.controller;

import com.medicalHistory.action.Login;
import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller("LoginController")
public class LoginController {


    private final DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public LoginController(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository= patientRepository;

    }

    @RequestMapping(path = "/login", method = GET)
    public String Login(){
        return "Login";
    }

    @RequestMapping(path = "/login", method = POST)
    public String Login(HttpSession httpSession,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "userType") String userType){

        boolean isLogged = new Login(doctorRepository, patientRepository).execute(httpSession, email, password, userType);
        if (isLogged) {
            if (userType.equals("doctor")) {
                return generateRedirectUrl(userType, ((Doctor) httpSession.getAttribute("user")).getId());
            }
            return generateRedirectUrl(userType, ((Patient) httpSession.getAttribute("user")).getId());
        }
        return "Login";
    }

    private String generateRedirectUrl(@RequestParam(value = "userType") String userType, long id) {
        return "redirect:/" + userType + "?id=" + id;
    }
}
