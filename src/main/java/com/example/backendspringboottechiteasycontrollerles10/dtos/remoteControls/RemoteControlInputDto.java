package com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class RemoteControlInputDto {
    @NotEmpty
    public String name;
    @NotEmpty
    public String brand;
    @NotEmpty
    public String batteryType;
    @NotNull
    @Digits(integer = 6, fraction = 2)
    public Double price;
    @PositiveOrZero
    public Integer originalStock;
    public String compatibleWith;

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
}
