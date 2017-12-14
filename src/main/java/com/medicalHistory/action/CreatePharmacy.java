package com.medicalHistory.action;

import com.medicalHistory.infrastructure.PharmacyRepository;
import com.medicalHistory.model.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("createPharmacyService")
public class CreatePharmacy {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public CreatePharmacy(PharmacyRepository pharmacyRepository){
        this.pharmacyRepository = pharmacyRepository;
    }

    public void execute(Pharmacy pharmacy){
        this.pharmacyRepository.saveAndFlush(pharmacy);
    }
}
