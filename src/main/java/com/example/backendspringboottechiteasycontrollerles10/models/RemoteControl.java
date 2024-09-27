package com.example.backendspringboottechiteasycontrollerles10.models;

import jakarta.persistence.*;

@Entity
@Table (name = "remote_controls")
public class RemoteControl {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String brand;
    private String batteryType;
    private Double price;
    private Integer originalStock;
    private String compatibleWith;

    @OneToOne (mappedBy = "remoteControl")
    private Television television;

    public RemoteControl(Long id, String name, String brand, String batteryType, Double price, Integer originalStock, String compatibleWith, Television television) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.batteryType = batteryType;
        this.price = price;
        this.originalStock = originalStock;
        this.compatibleWith = compatibleWith;
        this.television = television;
    }

    public RemoteControl(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
