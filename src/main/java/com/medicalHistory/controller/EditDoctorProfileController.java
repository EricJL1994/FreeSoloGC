package com.medicalHistory.controller;

import com.medicalHistory.action.CheckIfLogged;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller("EditDoctorProfileController")
public class EditDoctorProfileController {

    @RequestMapping(path = "/editDoctor", method = GET)
    public String editDoctor(HttpSession httpSession) {
        boolean isLogged = new CheckIfLogged().execute(httpSession);
        if (!isLogged) return "redirect:login";
        return "EditDoctorProfile";
    }
}
