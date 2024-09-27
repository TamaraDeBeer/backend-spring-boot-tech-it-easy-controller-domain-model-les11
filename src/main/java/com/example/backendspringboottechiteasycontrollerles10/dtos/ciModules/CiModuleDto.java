package com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules;

import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import jakarta.validation.Valid;

import java.util.List;

@Valid
public class CiModuleDto {
    public Long id;
    public String name;
    public String type;
    public Double price;
    public List<Television> televisionId;

    public CiModuleDto(Long id, String name, String type, Double price, List<Television> televisionId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.televisionId = televisionId;
    }

    public CiModuleDto() {
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

    public List<Television> getTelevisionId() {
        return televisionId;
    }

    public void setTelevisionId(List<Television> televisionId) {
        this.televisionId = televisionId;
    }
}
