package com.example.backendspringboottechiteasycontrollerles10.controllers;

import com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets.WallBracketDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.wallBrackets.WallBracketInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.WallBracket;
import com.example.backendspringboottechiteasycontrollerles10.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class WallBracketController {
    private final WallBracketService wallBracketService;
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }


    @GetMapping("/wallbrackets")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getAllWallBrackets());
    }

    @GetMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> getOneWallBracket(@PathVariable("id") Long id) {
        WallBracketDto wallBracketDto = wallBracketService.getWallBracketById(id);
        return ResponseEntity.ok().body(wallBracketDto);
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<WallBracketDto> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto = wallBracketService.createWallBracket(wallBracketInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + wallBracketDto.getId()).toUriString());
        return ResponseEntity.created(uri).body(wallBracketDto);
    }

    @PutMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketDto updateWallBracketDto) {
        WallBracketDto wallBracketDto = wallBracketService.updateWallBracket(id, updateWallBracketDto);
        if (wallBracketDto.id == null) {
            throw new RecordNotFoundException("Er is geen muurbeugel met dit id nummer: " + id);
        } else {
            return ResponseEntity.ok().body(wallBracketDto);
        }
    }

    @DeleteMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracket> deleteWallBracket (@PathVariable("id") Long id) {
            wallBracketService.deleteWallBracket(id);
            return ResponseEntity.noContent().build();
        }
}
