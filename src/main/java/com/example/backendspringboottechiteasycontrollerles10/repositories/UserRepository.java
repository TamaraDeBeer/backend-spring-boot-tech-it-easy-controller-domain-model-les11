package com.example.backendspringboottechiteasycontrollerles10.repositories;


import com.example.backendspringboottechiteasycontrollerles10.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}