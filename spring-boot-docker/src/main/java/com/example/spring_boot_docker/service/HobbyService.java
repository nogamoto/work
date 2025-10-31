package com.example.spring_boot_docker.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_docker.dto.HobbyDto;
import com.example.spring_boot_docker.mapper.HobbyMapper;
import com.example.spring_boot_docker.model.Hobby;
import com.example.spring_boot_docker.repository.HobbyRepository;

@Service
public class HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;
    @Autowired
    private HobbyMapper hobbyMapper;

    public Map<Integer, String> findAllHobbies() {
        List<Hobby> hobbies = hobbyRepository.findAll();
        Map<Integer, String> map = hobbies.stream().map(hobbyMapper::toDto)
                .collect(Collectors.toMap(
                        HobbyDto::getHobbyId, HobbyDto::getHobbyName,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return map;
    }

    public List<Hobby> findHobby(List<Integer> ids) {
        return hobbyRepository.findAllById(ids);
    }

    public List<Integer> map(List<Hobby> hobby) {
        List<Integer> hobbyIds = hobby.stream()
                .map(Hobby::getHobbyId)
                .toList();
        return hobbyIds;

    }
}
