package com.cs340.demo;

public class London {
    public double id;
    public String name;
    public String region;
    public String country;


    public London(double id, String name, String region, String country){
        this.id = id;
        this.name = name;
        this.region = region;
        this.country = country;

    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
