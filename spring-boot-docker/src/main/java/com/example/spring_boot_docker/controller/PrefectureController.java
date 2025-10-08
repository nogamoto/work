package com.example.spring_boot_docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_docker.model.Prefecture;
import com.example.spring_boot_docker.service.PrefecutureService;


@RestController
public class PrefectureController {

@Autowired
private PrefecutureService prefecutureService;


@GetMapping("path")//後で対応10/09~
public List<Prefecture> getAllPrefecture() {
    return prefecutureService.findAllPrefecture();
}

}
