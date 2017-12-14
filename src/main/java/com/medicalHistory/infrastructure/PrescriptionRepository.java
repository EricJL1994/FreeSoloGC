package com.medicalHistory.infrastructure;

import com.medicalHistory.model.Prescription;
import com.medicalHistory.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByRecordId(long recordId);
}
