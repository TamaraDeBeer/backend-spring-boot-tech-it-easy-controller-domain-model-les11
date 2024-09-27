package com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets;

import jakarta.validation.Valid;

@Valid
public class WallBracketDto {
    public Long id;
    public String name;
    public String size;
    public Boolean adjustable;
    public Double price;
    public Long televisionsId;

    public WallBracketDto(Long id, String name, String size, Boolean adjustable, Double price, Long televisionsId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.adjustable = adjustable;
        this.price = price;
        this.televisionsId = televisionsId;
    }

    public WallBracketDto() {
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

    public Long getTelevisionsId() {
        return televisionsId;
    }

    public void setTelevisionsId(Long televisionsId) {
        this.televisionsId = televisionsId;
    }
}
