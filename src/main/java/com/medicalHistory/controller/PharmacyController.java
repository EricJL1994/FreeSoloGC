package com.medicalHistory.controller;

import com.medicalHistory.action.CreatePharmacy;
import com.medicalHistory.infrastructure.PharmacyRepository;
import com.medicalHistory.model.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Eric on 30/03/2017.
 */

@Controller("PharmacyController")
public class PharmacyController {
    private final CreatePharmacy createPharmacy;
    private PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyController(CreatePharmacy createPharmacy, PharmacyRepository pharmacyRepository){
        this.createPharmacy = createPharmacy;
        this.pharmacyRepository = pharmacyRepository;
    }

    @RequestMapping(path= "/pharmacies", method = GET)
    public String listAllPharmacies(Model model){
        return "pharmacies";
    }

    @RequestMapping(path = "/pharmacies", method = POST)
    public String createPharmacy(@ModelAttribute Pharmacy pharmacy){
        createPharmacy.execute(pharmacy);
        return "redirect:/";
    }

    @RequestMapping(path = "/pharmacy", method = GET)
    public String viewProfile(@RequestParam("nif")int pharmacyID, Model model){
        model.addAttribute("pharmacy", pharmacyRepository.getOne((long) pharmacyID));
        return "PharmacyProfile";
    }
}
