package com.medicalHistory.controller;

import com.medicalHistory.action.CheckIfLogged;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller("indexController")
public class IndexController {

    private CheckIfLogged checkIfLogged;

    @Autowired
    public IndexController(CheckIfLogged checkIfLogged) {
        this.checkIfLogged = checkIfLogged;
    }

    @RequestMapping(path = "/", method = GET)
    public String index(HttpSession httpSession) {
        if (checkIfLogged.execute(httpSession)){
            Object user = httpSession.getAttribute("user");
            if (user instanceof Doctor) {
                return redirectUserToProfile((Doctor) user);
            }
            return redirectUserToProfile((Patient) user);
        }
        return "Index";
    }

    private String redirectUserToProfile(Doctor doctor){
        return "redirect:/doctor?id=" + doctor.getId();
    }

    private String redirectUserToProfile(Patient patient){
        return "redirect:/patient?id=" + patient.getId();
    }
}