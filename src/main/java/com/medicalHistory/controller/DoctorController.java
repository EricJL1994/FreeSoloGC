package com.medicalHistory.controller;

import com.medicalHistory.action.*;
import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Patient;
import com.medicalHistory.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller("DoctorController")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final AddRecordToPatientHistory addRecordToPatientHistoryService;
    private final ShowHistoryOfPatient showHistoryOfPatientAction;
    private final AssignPatientToDoctor assignPatientToDoctor;
    private final CheckIfLogged checkIfLogged;
    private final ListPatients listPatients;
    private final HasPermissionsToViewHistory hasPermissionsToViewHistory;
    private final FindDoctor findDoctor;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, AddRecordToPatientHistory addRecordToPatientHistoryService, ShowHistoryOfPatient showHistoryOfPatientAction, AssignPatientToDoctor assignPatientToDoctor, CheckIfLogged checkIfLogged, PatientRepository patientRepository, ListPatients listPatients, HasPermissionsToViewHistory hasPermissionsToViewHistory, FindDoctor findDoctor) {
        this.doctorRepository = doctorRepository;
        this.addRecordToPatientHistoryService = addRecordToPatientHistoryService;
        this.showHistoryOfPatientAction = showHistoryOfPatientAction;
        this.assignPatientToDoctor = assignPatientToDoctor;
        this.checkIfLogged = checkIfLogged;
        this.listPatients = listPatients;
        this.hasPermissionsToViewHistory = hasPermissionsToViewHistory;
        this.findDoctor = findDoctor;
    }

    @RequestMapping(path = "/doctors", method = POST)
    public String createDoctor(@ModelAttribute Doctor doctor) {
        try {
            new CreateDoctor(doctorRepository).execute(doctor);
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/doctors";
        }
    }

    @RequestMapping(path = "/doctors", method = GET)
    public String registerDoctor() {
        return "registerDoctor";
    }

    @RequestMapping(path = "/doctor", method = GET)
    public String doctorProfile(@RequestParam("id") int doctorId, Model model) {
        model.addAttribute("user", doctorRepository.getOne((long) doctorId));
        return "DoctorProfile";
    }

    @RequestMapping(path = "/updateDoctor", method = POST)
    public String updateDoctor(HttpSession httpSession, @ModelAttribute Doctor doctor) {
        long id = ((Doctor) httpSession.getAttribute("user")).getId();
        new UpdateDoctor(doctorRepository).execute(id, doctor);
        httpSession.setAttribute("user", doctor);
        return "redirect:/doctor?id=" + id;
    }

    @RequestMapping(path = "/doctors/patients/{id}/history", method = GET)
    public String patientHistory(@PathVariable("id") Long patientId, Model model, HttpSession httpSession) {
        if (!checkIfLogged.execute(httpSession)) return "redirect:/";
        Object user = httpSession.getAttribute("user");
        if (!hasPermissionsToViewHistory.execute(user, patientId)) return "redirect:/";
        Collection<Record> records = showHistoryOfPatientAction.execute(patientId);
        model.addAttribute("records", records);
        model.addAttribute("patientId", patientId);
        model.addAttribute("isADoctor", user instanceof Doctor);
        return "AddRecordToPatientHistory";
    }

    @RequestMapping(path = "/doctors/patients/{id}/history/new", method = POST)
    public String addRecordToPatientHistory(HttpSession httpSession, @PathVariable("id") Long id, @ModelAttribute Record record) {
        Doctor doctor = (Doctor) httpSession.getAttribute("user");
        addRecordToPatientHistoryService.execute(id, doctor, record);
        return String.format("redirect:/doctors/patients/%d/history", id);
    }

    @RequestMapping(path = "/findDoctor", method = GET)
    public String findDoctor(@RequestParam("doctorName") String doctorName, Model model) {
        List<Doctor> doctorFoundList = findDoctor.execute(doctorName);
        model.addAttribute("doctorList", doctorFoundList);
        return "FoundDoctors";
    }

    @PostMapping(path = "/assignDoctorToPatient")
    public String assignDoctorToPatient(@RequestParam("patientId") Long patientId, @RequestParam("doctorId") Long doctorId) {
        assignPatientToDoctor.execute(patientId, doctorId);
        return "redirect:/";
    }

    @GetMapping(path = "/doctors/patients")
    public String listDoctorPatients(HttpSession session, Model model) {
        if (!checkIfLogged.execute(session)) return "redirect:/";
        Doctor doctor = (Doctor) session.getAttribute("user");
        Collection<Patient> patients = listPatients.of(doctor);
        model.addAttribute("patients", patients);
        return "doctorPatients";
    }
}

