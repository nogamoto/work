package com.example.spring_boot_docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_docker.model.Prefecture;

@Repository
public interface PrefectureRepository extends JpaRepository<Prefecture, Integer> {

}
