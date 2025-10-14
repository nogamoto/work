package com.example.spring_boot_docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_docker.model.Prefecture;
import com.example.spring_boot_docker.service.PrefecutureService;


@RestController
@RequestMapping("/prefecture")
public class PrefectureController {

@Autowired
private PrefecutureService prefecutureService;


@GetMapping("getPre")
public List<Prefecture> getAllPrefecture() {
    return prefecutureService.findAllPrefecture();
}

}
