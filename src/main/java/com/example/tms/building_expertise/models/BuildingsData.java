package com.example.tms.building_expertise.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuildingsData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String date;
    private String year;
    private String floors;
    private String construct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getConstruct() {
        return construct;
    }

    public void setConstruct(String construct) {
        this.construct = construct;
    }

    public BuildingsData() {
    }

    public BuildingsData(String address, String date, String year, String floors, String construct) {
        this.address = address;
        this.date = date;
        this.year = year;
        this.floors = floors;
        this.construct = construct;
    }
}
