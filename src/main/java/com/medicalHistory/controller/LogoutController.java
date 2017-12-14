package com.medicalHistory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller("LogoutController")
public class LogoutController {

    @RequestMapping(path = "/logout", method = GET)
    public String Login(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

}
