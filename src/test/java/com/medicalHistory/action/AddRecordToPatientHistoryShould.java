package com.medicalHistory.action;

import com.medicalHistory.infrastructure.DoctorRepository;
import com.medicalHistory.infrastructure.PatientRepository;
import com.medicalHistory.infrastructure.RecordRepository;
import com.medicalHistory.model.Doctor;
import com.medicalHistory.model.History;
import com.medicalHistory.model.Patient;
import com.medicalHistory.model.Record;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class AddRecordToPatientHistoryShould {

    @Test
    public void persist_a_record() throws Exception {
        final Long anyPatientId = 1L;
        Patient patient = aPatient();
        Record deserializedRecord = aRecord();

        PatientRepository patientRepositorySpy = mock(PatientRepository.class);
        when(patientRepositorySpy.findOne(anyPatientId)).thenReturn(patient);
        RecordRepository recordRepositorySpy = mock(RecordRepository.class);

        serviceWith(patientRepositorySpy, recordRepositorySpy)
                .execute(anyPatientId, aDoctor(), deserializedRecord);

        verify(patientRepositorySpy).saveAndFlush(patient);
        assertThat(patient.getHistory().getRecords().isEmpty(), is(false));
        assertThat(deserializedRecord.getHistory(), is(notNullValue()));
        assertThat(deserializedRecord.getDoctor(), is(notNullValue()));
    }

    private AddRecordToPatientHistory serviceWith(PatientRepository patientRepositorySpy, RecordRepository recordRepositorySpy) {
        return new AddRecordToPatientHistory(patientRepositorySpy, recordRepositorySpy, mock(DoctorRepository.class));
    }

    private Doctor aDoctor() {
        return new Doctor();
    }

    private Patient aPatient() {
        Patient patient = new Patient();
        patient.setHistory(new History());
        return patient;
    }

    private Record aRecord() {
        String centre = "anyCentre";
        String symptoms = "anySymptoms";
        String tests = "anyTests";
        String diagnosis = "anyDiagnosis";
        String treatment = "anyTreatment";
        String observations = "anyObservations";
        return new Record()
                .setSymptoms(symptoms)
                .setTests(tests)
                .setDiagnosis(diagnosis)
                .setTreatment(treatment)
                .setDate(new Date())
                .setObservations(observations)
                .setCentre(centre);
    }
}
