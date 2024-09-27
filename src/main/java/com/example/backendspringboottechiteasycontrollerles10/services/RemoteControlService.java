package com.example.backendspringboottechiteasycontrollerles10.services;

import com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls.RemoteControlDto;
import com.example.backendspringboottechiteasycontrollerles10.dtos.remoteControls.RemoteControlInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.RemoteControl;
import com.example.backendspringboottechiteasycontrollerles10.repositories.RemoteControlRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControlService {

    private final RemoteControlRepository remoteControlRepository;

    public RemoteControlService(RemoteControlRepository remoteControlRepository) {
        this.remoteControlRepository = remoteControlRepository;
    }

    public List<RemoteControlDto> getAllRemoteControls() {
        List<RemoteControl> remoteControlList = remoteControlRepository.findAll();
        List<RemoteControlDto> remoteControlDtoList = new ArrayList<>();

        for (RemoteControl remoteControl : remoteControlList) {
            RemoteControlDto remoteControlDto = fromRemoteControl(remoteControl);
            remoteControlDtoList.add(remoteControlDto);
        }
        return remoteControlDtoList;
    }

    public RemoteControlDto createRemoteControl(RemoteControlInputDto remoteControlInputDto) {
        RemoteControl remoteControl = toRemoteControl(remoteControlInputDto);
        remoteControlRepository.save(remoteControl);
        return fromRemoteControl(remoteControl);
    }

    public RemoteControlDto getRemoteControlById(Long id) {
        Optional<RemoteControl> remoteControlId = remoteControlRepository.findById(id);
        if(remoteControlId.isPresent()) {
            RemoteControl remoteControl = remoteControlId.get();
            return fromRemoteControl(remoteControl);
        } else {
            throw new RecordNotFoundException("Er is geen afstandsbediening gevonden met id: " + id);
        }
    }

    public void deleteRemoteControl(@RequestParam Long id) {
        remoteControlRepository.deleteById(id);
    }

    public RemoteControlDto updateRemoteControl(@PathVariable Long id, @RequestBody RemoteControlDto updateRemoteControl) {
        Optional<RemoteControl> remoteControl = remoteControlRepository.findById(id);
        if(remoteControl.isEmpty()) {
            throw new RecordNotFoundException("Er is geen afstandsbediening gevonden met id: " + id);
        } else {
            RemoteControl remoteControl1 = remoteControl.get();
            remoteControl1.setName(updateRemoteControl.getName());
            remoteControl1.setBrand(updateRemoteControl.getBrand());
            remoteControl1.setBatteryType(updateRemoteControl.getBatteryType());
            remoteControl1.setPrice(updateRemoteControl.getPrice());
            remoteControl1.setOriginalStock(updateRemoteControl.getOriginalStock());
            remoteControl1.setCompatibleWith(updateRemoteControl.getCompatibleWith());
            RemoteControl remoteControl2 = remoteControlRepository.save(remoteControl1);
            return fromRemoteControl(remoteControl2);
        }
    }

    public RemoteControlDto fromRemoteControl(RemoteControl remoteControl) {
        var remoteControlDto = new RemoteControlDto();
        remoteControlDto.id = remoteControl.getId();
        remoteControlDto.name = remoteControl.getName();
        remoteControlDto.brand = remoteControl.getBrand();
        remoteControlDto.batteryType = remoteControl.getBatteryType();
        remoteControlDto.price = remoteControl.getPrice();
        remoteControlDto.originalStock = remoteControl.getOriginalStock();
        remoteControlDto.compatibleWith = remoteControl.getCompatibleWith();

        if (remoteControl.getTelevision() != null) {
            remoteControlDto.televisionId = remoteControl.getTelevision().getId();
        }

        return remoteControlDto;
    }

    public RemoteControl toRemoteControl(RemoteControlInputDto remoteControlInputDto) {
        var remoteControl = new RemoteControl();
        remoteControl.setName(remoteControlInputDto.name);
        remoteControl.setBrand(remoteControlInputDto.brand);
        remoteControl.setBatteryType(remoteControlInputDto.batteryType);
        remoteControl.setPrice(remoteControlInputDto.price);
        remoteControl.setOriginalStock(remoteControlInputDto.originalStock);
        remoteControl.setCompatibleWith(remoteControlInputDto.compatibleWith);
        return remoteControl;
    }
}
