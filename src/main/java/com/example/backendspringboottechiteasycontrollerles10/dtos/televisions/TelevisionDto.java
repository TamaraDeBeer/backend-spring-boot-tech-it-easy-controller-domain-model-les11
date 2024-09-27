package com.example.backendspringboottechiteasycontrollerles10.dtos.televisions;

import com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules.CiModuleDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls.RemoteControlDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets.WallBracketDto;
import com.example.backendspringboottechiteasycontrollerles10.models.WallBracket;
import jakarta.validation.Valid;

import java.util.List;

@Valid
public class TelevisionDto {
    public Long id;
    public String type;
    public String brand;
    public String name;
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;
    public CiModuleDto ciModuleDto;
    public RemoteControlDto remoteControlDto;

    public List<WallBracketDto> wallBracketDtoList;

    public TelevisionDto(Long id, String type, String brand, String name, Double price, Double availableSize, Double refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock, Integer sold, CiModuleDto ciModuleDto, RemoteControlDto remoteControlDto, List<WallBracketDto> wallBracketDtoList) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
        this.ciModuleDto = ciModuleDto;
        this.remoteControlDto = remoteControlDto;
        this.wallBracketDtoList = wallBracketDtoList;
    }

    public TelevisionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public CiModuleDto getCiModuleDto() {
        return ciModuleDto;
    }

    public void setCiModuleDto(CiModuleDto ciModuleDto) {
        this.ciModuleDto = ciModuleDto;
    }

    public RemoteControlDto getRemoteControlDto() {
        return remoteControlDto;
    }

    public void setRemoteControlDto(RemoteControlDto remoteControlDto) {
        this.remoteControlDto = remoteControlDto;
    }

    public List<WallBracketDto> getWallBracketDtoList() {
        return wallBracketDtoList;
    }

    public void setWallBracketDtoList(List<WallBracketDto> wallBracketDtoList) {
        this.wallBracketDtoList = wallBracketDtoList;
    }
}
