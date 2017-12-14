package com.medicalHistory.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String medicalCenter;
    private String password;
    private String email;

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "patients_doctors", joinColumns =
        @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    private Collection<Patient> patients;

    public Doctor() {
        this.patients = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMedicalCenter(String medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public String getName() {
        return name;
    }

    public String getMedicalCenter() {
        return medicalCenter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public Collection<Patient> getPatients() {
        return patients;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Doctor && ((Doctor) obj).getId() == id;
    }
}
