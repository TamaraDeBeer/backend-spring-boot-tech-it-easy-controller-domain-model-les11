package com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CiModuleInputDto {
    @NotEmpty
    public String name;
    @NotEmpty
    public String type;
    @NotNull
    @Digits(integer = 6, fraction = 2)
    public Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
