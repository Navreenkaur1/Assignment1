package com.example.assignment1;

public class carmodel {
    public carmodel(String name_, String fuel, String seller_type, String transmission, String Owner_, int carmodelID, int year_, int selling_price, int kmdriven) {
        this.name_ = name_;
        this.fuel = fuel;
        this.seller_type = seller_type;
        this.transmission = transmission;
        this.Owner_ = Owner_;
        this.carmodelID = carmodelID;
        this.year_ = year_;
        this.selling_price = selling_price;
        this.kmdriven = kmdriven;
    }


    public carmodel(int carmodelID, String name_, int year_, int selling_price, int kmdriven, String fuel, String seller_type, String transmission, String owner_) {
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getSeller_type() {
        return seller_type;
    }

    public void setSeller_type(String seller_type) {
        this.seller_type = seller_type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getOwner_() {
        return Owner_;
    }

    public void setOwner_(String owner_) {
        Owner_ = owner_;
    }

    public int getCarmodelID() {
        return carmodelID;
    }

    public void setCarmodelID(int carmodelID) {
        if (carmodelID >0)
            this.carmodelID = carmodelID;
        else
            throw new IllegalArgumentException("carmodelID should be greater than 0");

    }

    public int getYear_() {
        return year_;
    }

    public void setYear_(int year_) {
        this.year_ = year_;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public int getKmdriven() {
        return kmdriven;
    }

    public void setKmdriven(int kmdriven) {
        this.kmdriven = kmdriven;
    }

    public String name_,fuel, seller_type, transmission, Owner_;
    public int  carmodelID,year_,selling_price,kmdriven;

    
    }


 

