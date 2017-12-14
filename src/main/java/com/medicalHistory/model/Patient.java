package com.medicalHistory.model;

import javax.persistence.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String phone;
    private Date dateofbirth;
    private String dni;
    private String gender;
    private String address;
    private String email;
    private String password;

    @OneToOne(targetEntity = History.class, cascade = ALL)
    @PrimaryKeyJoinColumn(name = "history_id")
    private History history;

    @ManyToMany(mappedBy = "patients")
    private Collection<Doctor> doctors;

    public Patient() {
        this.doctors = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateofbirth() {
        Format outputDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String newDateOfBirthFormat = outputDateFormat.format(dateofbirth);
        return newDateOfBirthFormat;
    }

    public void setDateofbirth(Date dateofbirth) {

        this.dateofbirth = dateofbirth;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public History getHistory() {
        return history;
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }

    public void addRecordToHistory(Record record) {
        this.history.addRecord(record);
    }

    public Collection<Record> getHistoryRecords() {
        return this.history.getRecords();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public Collection<Doctor> getDoctors() {
        return doctors;
    }

    public boolean hasPermissionsToViewHistory(Doctor user) {
        return doctors.contains(user);
    }

    public boolean hasId(Long id) {
        return id == this.id;
    }
}
