package com.example.spring_boot_docker.service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_docker.model.Prefecture;
import com.example.spring_boot_docker.repository.PrefectureRepository;

@Service
public class PrefectureService {
    @Autowired
    private PrefectureRepository prefectureRepository;

    public Map<String, Integer> findAllPrefecture() {
        List<Prefecture> prefectures = prefectureRepository.findAll();
        Map<String, Integer> map = prefectures.stream().collect(Collectors
                .toMap(Prefecture::getPrefectureName, Prefecture::getPrefectureId));
        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return map;
    }

    public Prefecture findPrefecture(Integer id) {
        return prefectureRepository.findById(id).orElseThrow();
    }
}
