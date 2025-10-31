package com.example.spring_boot_docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_docker.model.Hobby;

public interface HobbyRepository extends JpaRepository<Hobby, Integer> {
}
