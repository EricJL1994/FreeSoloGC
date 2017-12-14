package com.medicalHistory.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity = Record.class, mappedBy = "history", cascade = ALL)
    private Collection<Record> records;

    public History() {
        this.records = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void addRecord(Record record) {
        if (!records.contains(record)) {
            records.add(record);
        }
    }

    public Collection<Record> getRecords() {
        return records;
    }
}
