package com.medicalHistory.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String centre;
    private String symptoms;
    private String tests;
    private String diagnosis;
    private String treatment;
    private String observations;
    private Date date;

    @ManyToOne(targetEntity = History.class, cascade = {PERSIST, REFRESH})
    @JoinColumn(name = "history_id")
    private History history;

    @ManyToOne(targetEntity = Doctor.class, cascade = ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Record setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public String getCentre() {
        return centre;
    }

    public Record setCentre(String centre) {
        this.centre = centre;
        return this;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public Record setSymptoms(String symptoms) {
        this.symptoms = symptoms;
        return this;
    }

    public String getTests() {
        return tests;
    }

    public Record setTests(String tests) {
        this.tests = tests;
        return this;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Record setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public String getTreatment() {
        return treatment;
    }

    public Record setTreatment(String treatment) {
        this.treatment = treatment;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public Record setObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Record setDate(Date date) {
        this.date = date;
        return this;
    }

    public History getHistory() {
        return history;
    }

    public Record setHistory(History history) {
        this.history = history;
        return this;
    }

}
