package com.medicalHistory.action;

import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.model.History;
import com.medicalHistory.model.Patient;
import com.medicalHistory.model.Record;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowHistoryOfPatientShould {

    @Test
    public void find_all_records_of_a_history() {
        final Long anyPatientId = 1L;
        Patient patient = aPatient();
        Record record = new Record();
        patient.addRecordToHistory(record);

        PatientRepository patientRepositoryStub = mock(PatientRepository.class);
        when(patientRepositoryStub.findOne(anyPatientId)).thenReturn(patient);

        Collection<Record> records = new ShowHistoryOfPatient(patientRepositoryStub).execute(anyPatientId);

        assertThat(records).hasSize(1);
        assertThat(records.contains(record)).isTrue();
    }

    private Patient aPatient() {
        Patient patient = new Patient();
        patient.setHistory(new History());
        return patient;
    }
}
