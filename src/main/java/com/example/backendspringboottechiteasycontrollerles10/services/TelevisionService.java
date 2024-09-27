package com.example.backendspringboottechiteasycontrollerles10.services;

import com.example.backendspringboottechiteasycontrollerles10.dtos.televisions.TelevisionDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.televisions.TelevisionInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import com.example.backendspringboottechiteasycontrollerles10.models.WallBracket;
import com.example.backendspringboottechiteasycontrollerles10.repositories.CiModuleRepository;
import com.example.backendspringboottechiteasycontrollerles10.repositories.RemoteControlRepository;
import com.example.backendspringboottechiteasycontrollerles10.repositories.TelevisionRepository;
import com.example.backendspringboottechiteasycontrollerles10.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final RemoteControlRepository remoteControlRepository;
    private final RemoteControlService remoteControlService;
    private final CiModuleRepository ciModuleRepository;
    private final CiModuleService ciModuleService;
    private final WallBracketService wallBracketService;
    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteControlRepository remoteControlRepository, RemoteControlService remoteControlService, CiModuleRepository ciModuleRepository, CiModuleService ciModuleService, WallBracketService wallBracketService, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControlRepository = remoteControlRepository;
        this.remoteControlService = remoteControlService;
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleService = ciModuleService;
        this.wallBracketService = wallBracketService;
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisionList = televisionRepository.findAll();
        List<TelevisionDto> televisionDtoList = new ArrayList<>();

        for (Television television : televisionList) {
            TelevisionDto televisionDto = fromTelevision(television);
            televisionDtoList.add(televisionDto);
        }
        return televisionDtoList;
    }

    public TelevisionDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television television = toTelevision(televisionInputDto);
        televisionRepository.save(television);
        return fromTelevision(television);
    }

    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> televisionId = televisionRepository.findById(id);
        if (televisionId.isPresent()) {
            Television television = televisionId.get();
            return fromTelevision(television);
        } else {
            throw new RecordNotFoundException("Er is geen televisie gevonden met id: " + id);
        }
    }

    public void deleteTelevision(@RequestParam Long id) {
        televisionRepository.deleteById(id);
    }

    public TelevisionDto updateTelevision(@PathVariable Long id, @RequestBody TelevisionDto updateTelevision) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new RecordNotFoundException("Er is geen televisie met id nummer: " + id);
        } else {
            Television television1 = television.get();
            television1.setType(updateTelevision.getType());
            television1.setBrand(updateTelevision.getBrand());
            television1.setName(updateTelevision.getName());
            television1.setPrice(updateTelevision.getPrice());
            television1.setAvailableSize(updateTelevision.getAvailableSize());
            television1.setRefreshRate(updateTelevision.getRefreshRate());
            television1.setScreenType(updateTelevision.getScreenType());
            television1.setScreenQuality(updateTelevision.getScreenQuality());
            television1.setSmartTv(updateTelevision.getSmartTv());
            television1.setWifi(updateTelevision.getWifi());
            television1.setVoiceControl(updateTelevision.getVoiceControl());
            television1.setHdr(updateTelevision.getHdr());
            television1.setBluetooth(updateTelevision.getBluetooth());
            television1.setAmbiLight(updateTelevision.getAmbiLight());
            television1.setOriginalStock(updateTelevision.getOriginalStock());
            television1.setSold(updateTelevision.getSold());

            Television television2 = televisionRepository.save(television1);
            return fromTelevision(television2);
        }
    }

    // stap 13 t/m 16 - maar de functie werkte niet bij aanroepen wanneer deze zich in de TelevisionDto.java bevond dus heb hem hierheen verplaatst.
    public TelevisionDto fromTelevision(Television television) {
        var televisionDto = new TelevisionDto();
        televisionDto.setId(television.getId());
        televisionDto.setType(television.getType());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setName(television.getName());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());
        televisionDto.setScreenQuality(television.getScreenQuality());
        televisionDto.setSmartTv(television.getSmartTv());
        televisionDto.setWifi(television.getWifi());
        televisionDto.setVoiceControl(television.getVoiceControl());
        televisionDto.setHdr(television.getHdr());
        televisionDto.setBluetooth(television.getBluetooth());
        televisionDto.setAmbiLight(television.getAmbiLight());
        televisionDto.setOriginalStock(television.getOriginalStock());
        televisionDto.setSold(television.getSold());

        if(television.getRemoteControl() != null) {
            televisionDto.setRemoteControlDto(remoteControlService.fromRemoteControl(television.getRemoteControl()));
        }

        if(television.getCiModule() != null) {
            televisionDto.setCiModuleDto(ciModuleService.fromCiModule(television.getCiModule()));
        }

//        if(television.getWallBracketsList() != null) {
//            televisionDto.setWallBracketDtoList(wallBracketService.fromWallBracketList(television.getWallBracketsList()));
//        }

        return televisionDto;
    }

    // stap 19 t/m 21 - maar de functie werkte niet bij aanroepen wanneer deze zich in de TelevisionInputDto.java bevond dus heb hem hierheen verplaatst.
    public Television toTelevision(TelevisionInputDto televisionInputDto) {
        var television = new Television();
        television.setType(televisionInputDto.getType());
        television.setBrand(televisionInputDto.getBrand());
        television.setName(televisionInputDto.getName());
        television.setPrice(televisionInputDto.getPrice());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setRefreshRate(televisionInputDto.getRefreshRate());
        television.setScreenType(televisionInputDto.getScreenType());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setSmartTv(televisionInputDto.getSmartTv());
        television.setWifi(televisionInputDto.getWifi());
        television.setVoiceControl(televisionInputDto.getVoiceControl());
        television.setHdr(televisionInputDto.getHdr());
        television.setBluetooth(televisionInputDto.getBluetooth());
        television.setAmbiLight(televisionInputDto.getAmbiLight());
        television.setOriginalStock(televisionInputDto.getOriginalStock());
        television.setSold(televisionInputDto.getSold());

        return television;
    }

    public void assignRemoteControllerToTelevision (Long id, Long remoteControlId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemoteControl = remoteControlRepository.findById(remoteControlId);

        if (optionalTelevision.isPresent() && optionalRemoteControl.isPresent()) {
            var television = optionalTelevision.get();
            var remoteControl = optionalRemoteControl.get();
            television.setRemoteControl(remoteControl);
            televisionRepository.save(television);
            } else {
            throw new RecordNotFoundException("Er is geen televisie gevonden met id: " + id + " en/of geen afstandsbediening met id: " + remoteControlId);
        }
    }

    public void assignCiModuleToTelevision (Long id, Long ciModuleId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalCiModule = ciModuleRepository.findById(ciModuleId);

        if (optionalTelevision.isPresent() && optionalCiModule.isPresent()) {
            var television = optionalTelevision.get();
            var ciModule = optionalCiModule.get();
            television.setCiModule(ciModule);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException("Er is geen televisie gevonden met id: " + id + " en/of geen ci module met id: " + ciModuleId);
        }
    }

//    public void assignWallBracketToTelevision (Long id, Long wallBracketsId) {
//        var optionalTelevision = televisionRepository.findById(id);
//        var optionalWallBracket = wallBracketRepository.findById(wallBracketsId);
//
//        if (optionalTelevision.isPresent() && optionalWallBracket.isPresent()) {
//            var television = optionalTelevision.get();
//            var wallBracket = optionalWallBracket.get();
//            television.setWallBracketsList(wallBracket);
//            televisionRepository.save(television);
//        } else {
//            throw new RecordNotFoundException("Er is geen televisie gevonden met id: " + id + " en/of geen muurbeugel met id: " + wallBracketsId);
//        }
//    }



}
