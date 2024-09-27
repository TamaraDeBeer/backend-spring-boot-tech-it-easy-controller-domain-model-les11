package com.example.backendspringboottechiteasycontrollerles10.services;

import com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls.RemoteControlDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets.WallBracketDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets.WallBracketInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.WallBracket;
import com.example.backendspringboottechiteasycontrollerles10.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto>getAllWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();

        for (WallBracket wallBracket : wallBracketList) {
            WallBracketDto wallBracketDto = fromWallBracket(wallBracket);
            wallBracketDtoList.add(wallBracketDto);
        }
        return wallBracketDtoList;
    }

    public WallBracketDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = toWallBracket(wallBracketInputDto);
        wallBracketRepository.save(wallBracket);
        return fromWallBracket(wallBracket);
    }

    public WallBracketDto getWallBracketById(Long id) {
        Optional<WallBracket> wallBracketId = wallBracketRepository.findById(id);
        if (wallBracketId.isPresent()) {
            WallBracket wallBracket = wallBracketId.get();
            return fromWallBracket(wallBracket);
        } else {
            throw new RecordNotFoundException("Er is geen muurbeugel gevonden met id: " + id);
        }
    }

    public void deleteWallBracket(@RequestParam Long id) {
        wallBracketRepository.deleteById(id);
    }

    public WallBracketDto updateWallBracket (@PathVariable Long id, @RequestBody WallBracketDto updateWallBracket) {
        Optional<WallBracket> wallBracket = wallBracketRepository.findById(id);
        if(wallBracket.isEmpty()) {
            throw new RecordNotFoundException("Er is geen muurbeugel gevonden met id: " + id);
        } else {
            WallBracket wallBracket1 = wallBracket.get();
            wallBracket1.setName(updateWallBracket.getName());
            wallBracket1.setSize(updateWallBracket.getSize());
            wallBracket1.setAdjustable(updateWallBracket.getAdjustable());
            wallBracket1.setPrice(updateWallBracket.getPrice());
            WallBracket wallBracket2 = wallBracketRepository.save(wallBracket1);
            return fromWallBracket(wallBracket2);
        }
    }

    public WallBracketDto fromWallBracket(WallBracket wallBracket) {
        var wallBracketDto = new WallBracketDto();
        wallBracketDto.id = wallBracket.getId();
        wallBracketDto.name = wallBracket.getName();
        wallBracketDto.size = wallBracket.getSize();
        wallBracketDto.adjustable = wallBracket.getAdjustable();
        wallBracketDto.price = wallBracket.getPrice();

        if(wallBracket.getTelevisionsList() != null) {
            wallBracketDto.televisionsId = wallBracket.getTelevisionsList().get(0).getId();
        }

        return wallBracketDto;
    }

    public WallBracket toWallBracket(WallBracketInputDto wallBracketInputDto) {
        var wallBracket = new WallBracket();
        wallBracket.setName(wallBracketInputDto.name);
        wallBracket.setSize(wallBracketInputDto.size);
        wallBracket.setAdjustable(wallBracketInputDto.adjustable);
        wallBracket.setPrice(wallBracketInputDto.price);
        return wallBracket;
    }
}
