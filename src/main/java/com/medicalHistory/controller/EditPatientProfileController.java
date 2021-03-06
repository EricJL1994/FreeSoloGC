package com.medicalHistory.controller;

import com.medicalHistory.action.CheckIfLogged;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller("EditPatientProfileController")
public class EditPatientProfileController {

    @RequestMapping(path = "/editPatient", method = GET)
    public String editPatient(HttpSession httpSession, Model model) {
        boolean isLogged = new CheckIfLogged().execute(httpSession);
        if (!isLogged) return "redirect:login";
        model.addAttribute("user", httpSession.getAttribute("user"));
        return "EditPatientProfile";
    }
}
