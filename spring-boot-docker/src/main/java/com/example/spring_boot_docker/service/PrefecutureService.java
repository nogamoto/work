package com.example.spring_boot_docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_docker.model.Prefecture;
import com.example.spring_boot_docker.repository.PrefectureRepository;

@Service
public class PrefecutureService {
@Autowired
private PrefectureRepository prefectureRepository;

public List<Prefecture> findAllPrefecture(){
    return prefectureRepository.findAll();
}

public Prefecture findPrefecture(Integer id){
    Prefecture prefecture = prefectureRepository.findById(id).orElseThrow();
    return prefecture;
}
}
