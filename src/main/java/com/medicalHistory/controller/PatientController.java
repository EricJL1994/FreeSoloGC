package com.medicalHistory.controller;

import com.medicalHistory.action.CreatePatient;
import com.medicalHistory.action.FindPatient;
import com.medicalHistory.action.UpdatePatient;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller("PatientController")
public class PatientController {

    private final CreatePatient createPatient;
    private final PatientRepository patientRepository;
    private final FindPatient findPatient;

    @Autowired
    public PatientController(CreatePatient createPatient, PatientRepository patientRepository, FindPatient findPatient) {
        this.createPatient = createPatient;
        this.patientRepository = patientRepository;
        this.findPatient = findPatient;
    }

    @RequestMapping(path = "/patients", method = GET)
    public String listAllPatients(Model model) {
        // TODO findAll patients from repository
        return "patients";
    }

    @RequestMapping(path = "/patients", method = POST)
    public String createPatient(@ModelAttribute Patient patient, Model model) {
        try {
            createPatient.execute(patient);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Email already used");
            return "redirect:/patients";
        }
    }

    @RequestMapping(path = "/patient", method = GET)
    public String viewProfile(@RequestParam("id")int patientID, Model model){
        model.addAttribute("user", patientRepository.getOne((long) patientID));
        return "PatientProfile";
    }

    @RequestMapping(path = "/updatePatient", method = POST)
    public String updatePatient(HttpSession httpSession, @ModelAttribute Patient patient) {
        long id = ((Patient) httpSession.getAttribute("user")).getId();
        new UpdatePatient(patientRepository).execute(id, patient);
        httpSession.setAttribute("user", patient);
        return "redirect:/patient?id=" + id;
    }

    @RequestMapping(path = "/findPatient", method = GET)
    public String findPatient(@RequestParam("patientName") String patientName, Model model) {
        List<Patient> patientFoundList = findPatient.execute(patientName);
        model.addAttribute("patientList", patientFoundList);
        return "FoundPatients";
    }
}
