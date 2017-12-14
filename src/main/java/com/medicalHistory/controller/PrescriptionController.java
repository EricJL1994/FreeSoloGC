package com.medicalHistory.controller;

import com.medicalHistory.action.CheckIfLogged;
import com.medicalHistory.action.HasPermissionsToViewHistory;
import com.medicalHistory.infrastructure.PrescriptionRepository;
import com.medicalHistory.infrastructure.RecordRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.Prescription;
import com.medicalHistory.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller("PrescriptionController")
public class PrescriptionController {

    private PrescriptionRepository prescriptionRepository;
    private RecordRepository recordRepository;
    private CheckIfLogged checkIfLogged;
    private HasPermissionsToViewHistory hasPermissionsToViewHistory;

    @Autowired
    public PrescriptionController(PrescriptionRepository prescriptionRepository, RecordRepository recordRepository, CheckIfLogged checkIfLogged, HasPermissionsToViewHistory hasPermissionsToViewHistory) {
        this.prescriptionRepository = prescriptionRepository;
        this.recordRepository = recordRepository;
        this.checkIfLogged = checkIfLogged;
        this.hasPermissionsToViewHistory = hasPermissionsToViewHistory;
    }

    @RequestMapping(path = "/addPrescription", method = POST)
    public String addPrescription(@ModelAttribute Prescription prescription, @RequestParam("recordId") Long recordId, @RequestParam("patientId") Long patientId){
        Record record = recordRepository.findOne(recordId);
        prescription.setRecord(record);
        prescriptionRepository.saveAndFlush(prescription);
        return String.format("redirect:/doctors/patients/%d/record/%d/prescriptions", patientId, recordId);
    }

    @RequestMapping(path = "/doctors/patients/{patientId}/record/{recordId}/prescriptions", method = GET)
    public String viewPrescription(@PathVariable("patientId") Long patientId, @PathVariable("recordId") Long recordId, Model model, HttpSession httpSession){
        if (!checkIfLogged.execute(httpSession)) return "redirect:/";
        Object user = httpSession.getAttribute("user");
        if (!hasPermissionsToViewHistory.execute(user, patientId)) return "redirect:/";
        List<Prescription> prescriptions = prescriptionRepository.findByRecordId(recordId);
        Record record = recordRepository.findOne(recordId);
        model.addAttribute("recordId", recordId);
        model.addAttribute("record", record);
        model.addAttribute("patientId", patientId);
        model.addAttribute("isADoctor", user instanceof Doctor);
        model.addAttribute("prescriptions", prescriptions);
        return "Prescriptions";
    }
}
