package com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls;

import com.example.backendspringboottechiteasycontrollerles10.dtos.televisions.TelevisionDto;
import jakarta.validation.Valid;

@Valid
public class RemoteControlDto {
    public Long id;
    public String name;
    public String brand;
    public String batteryType;
    public Double price;
    public Integer originalStock;
    public String compatibleWith;
    public Long televisionId;

    public RemoteControlDto(Long id, String name, String brand, String batteryType, Double price, Integer originalStock, String compatibleWith, Long televisionId) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.batteryType = batteryType;
        this.price = price;
        this.originalStock = originalStock;
        this.compatibleWith = compatibleWith;
        this.televisionId = televisionId;
    }

    public RemoteControlDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getTelevisionId() {
        return televisionId;
    }

    public void setTelevisionId(Long televisionId) {
        this.televisionId = televisionId;
    }
}
