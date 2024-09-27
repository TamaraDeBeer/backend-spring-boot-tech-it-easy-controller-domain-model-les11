package com.example.backendspringboottechiteasycontrollerles10.controllers;


import com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls.RemoteControlDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls.RemoteControlInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.RemoteControl;
import com.example.backendspringboottechiteasycontrollerles10.services.RemoteControlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RemoteControlController {
    private final RemoteControlService remoteControlService;
    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }

    @GetMapping("/remotecontrols")
    public ResponseEntity<List<RemoteControlDto>> getAllRemoteControls() {
        return ResponseEntity.ok(remoteControlService.getAllRemoteControls());
    }

    @GetMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlDto> getOneRemoteControl(@PathVariable("id") Long id) {
        RemoteControlDto remoteControlDto = remoteControlService.getRemoteControlById(id);
        return ResponseEntity.ok().body(remoteControlDto);
    }

    @PostMapping("/remotecontrols")
    public ResponseEntity<RemoteControlDto> createRemoteControl(@Valid @RequestBody RemoteControlInputDto remoteControlInputDto) {
        RemoteControlDto remoteControlDto = remoteControlService.createRemoteControl(remoteControlInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + remoteControlDto.getId()).toUriString());
        return ResponseEntity.created(uri).body(remoteControlDto);
    }

    @PutMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlDto> updateRemoteControl(@PathVariable Long id, @RequestBody RemoteControlDto updateRemoteControlDto) {
        RemoteControlDto remoteControlDto = remoteControlService.updateRemoteControl(id, updateRemoteControlDto);
        if (remoteControlDto.id == null) {
            throw new RecordNotFoundException("Er is geen afstandbediening met dit id nummer: " + id);
        } else {
            return ResponseEntity.ok().body(remoteControlDto);
        }
    }

    @DeleteMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControl> deleteRemoteControl(@PathVariable("id") Long id) {
                remoteControlService.deleteRemoteControl(id);
        return ResponseEntity.noContent().build();
    }

}
