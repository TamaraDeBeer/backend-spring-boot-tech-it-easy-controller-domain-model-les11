package com.example.backendspringboottechiteasycontrollerles10.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "ci_modules")
public class CiModule {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private Double price;

    @OneToMany (mappedBy = "ciModule")
    private List<Television> televisionsList;

    public CiModule(Long id, String name, String type, Double price, List<Television> televisionsList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.televisionsList = televisionsList;
    }

    public CiModule(){}

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

    public List<Television> getTelevisionsList() {
        return televisionsList;
    }

    public void setTelevisionsList(List<Television> televisionsList) {
        this.televisionsList = televisionsList;
    }
}
