package com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WallBracketInputDto {
    @NotEmpty
    public String name;
    public String size;
    public Boolean adjustable;
    @NotNull
    @Digits(integer = 6, fraction = 2)
    public Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
