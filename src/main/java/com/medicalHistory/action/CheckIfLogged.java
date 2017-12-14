package com.medicalHistory.action;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CheckIfLogged {
    public boolean execute(HttpSession httpSession) {
        return httpSession.getAttribute("user") != null;
    }
}
