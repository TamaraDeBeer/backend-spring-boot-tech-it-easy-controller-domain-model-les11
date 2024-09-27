package com.example.backendspringboottechiteasycontrollerles10.controllers;

import com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules.CiModuleDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.ciModules.CiModuleInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.CiModule;
import com.example.backendspringboottechiteasycontrollerles10.services.CiModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CiModuleController {
    private final CiModuleService ciModuleService;
    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping("/cimodules")
    public ResponseEntity<List<CiModuleDto>> getAllCiModules() {
        return ResponseEntity.ok(ciModuleService.getAllCiModules());
    }

    @GetMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleDto> getOneCiModule(@PathVariable("id") Long id) {
        CiModuleDto ciModuleDto = ciModuleService.getCiModuleById(id);
        return ResponseEntity.ok().body(ciModuleDto);
    }

    @PostMapping("/cimodules")
    public ResponseEntity<CiModuleDto> createCiModule(@Valid @RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModuleDto ciModuleDto = ciModuleService.createCiModule(ciModuleInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
               .fromCurrentRequest()
                .path("/" + ciModuleDto.getId()).toUriString());
        return ResponseEntity.created(uri).body(ciModuleDto);
    }

    @PutMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleDto> updateCiModule(@PathVariable Long id, @RequestBody CiModuleDto updateCiModuleDto) {
        CiModuleDto ciModuleDto = ciModuleService.updateCiModule(id, updateCiModuleDto);
        if (ciModuleDto.id == null) {
            throw new RecordNotFoundException("Er is geen ci-module met dit id nummer: " + id);
        } else {
            return ResponseEntity.ok().body(ciModuleDto);
        }
    }

    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity<CiModule> deleteCiModule(@PathVariable("id") Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }
}
