package com.example.backendspringboottechiteasycontrollerles10.services;

import com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules.CiModuleDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules.CiModuleInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.CiModule;
import com.example.backendspringboottechiteasycontrollerles10.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModuleDto> getAllCiModules() {
        List<CiModule> ciModuleList = ciModuleRepository.findAll();
        List<CiModuleDto> ciModuleDtoList = new ArrayList<>();

        for (CiModule ciModule : ciModuleList) {
            CiModuleDto ciModuleDto = fromCiModule(ciModule);
            ciModuleDtoList.add(ciModuleDto);
        }
        return ciModuleDtoList;
    }

    public CiModuleDto createCiModule(CiModuleInputDto ciModuleInputDto) {
        CiModule ciModule = toCiModule(ciModuleInputDto);
        ciModuleRepository.save(ciModule);
        return fromCiModule(ciModule);
    }

    public CiModuleDto getCiModuleById(Long id) {
        Optional<CiModule> ciModuleId = ciModuleRepository.findById(id);
        if (ciModuleId.isPresent()) {
            CiModule ciModule = ciModuleId.get();
            return fromCiModule(ciModule);
        } else {
            throw new RecordNotFoundException("Er is geen ci module gevonden met id: " + id);
        }
    }

    public void deleteCiModule(@RequestParam Long id) {
        ciModuleRepository.deleteById(id);
    }

    public CiModuleDto updateCiModule(@PathVariable Long id, @RequestBody CiModuleDto updateCiModule) {
        Optional<CiModule> ciModule = ciModuleRepository.findById(id);
        if(ciModule.isEmpty()) {
            throw new RecordNotFoundException("Er is geen ci module gevonden met id: " + id);
        } else {
            CiModule ciModule1 = ciModule.get();
            ciModule1.setName(updateCiModule.getName());
            ciModule1.setType(updateCiModule.getType());
            ciModule1.setPrice(updateCiModule.getPrice());
            CiModule ciModule2 = ciModuleRepository.save(ciModule1);
            return fromCiModule(ciModule2);
        }
    }


    public CiModuleDto fromCiModule(CiModule ciModule) {
        var ciModuleDto = new CiModuleDto();
        ciModuleDto.id = ciModule.getId();
        ciModuleDto.name = ciModule.getName();
        ciModuleDto.type = ciModule.getType();
        ciModuleDto.price = ciModule.getPrice();

//        if(ciModule.getTelevisionsList() != null) {
//            ciModuleDto.televisionId = ciModule.getTelevisionsList();
//        }

        return ciModuleDto;
    }

    public CiModule toCiModule(CiModuleInputDto ciModuleInputDto) {
        var ciModule = new CiModule();
        ciModule.setType(ciModuleInputDto.type);
        ciModule.setPrice(ciModuleInputDto.price);
        ciModule.setName(ciModuleInputDto.name);
        return ciModule;
    }
}
