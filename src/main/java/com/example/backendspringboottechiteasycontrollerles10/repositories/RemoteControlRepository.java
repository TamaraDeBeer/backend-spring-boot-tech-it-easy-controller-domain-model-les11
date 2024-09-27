package com.example.backendspringboottechiteasycontrollerles10.repositories;

import com.example.backendspringboottechiteasycontrollerles10.models.RemoteControl;
import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControlRepository extends JpaRepository<RemoteControl, Long> {
}
