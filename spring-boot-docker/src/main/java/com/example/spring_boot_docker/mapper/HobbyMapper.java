package com.example.spring_boot_docker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.spring_boot_docker.dto.HobbyDto;
import com.example.spring_boot_docker.model.Hobby;

@Mapper(componentModel = "spring")
public interface HobbyMapper {

    @Mapping(target = "employee", ignore = true)
    Hobby toEntity(HobbyDto dto);

    HobbyDto toDto(Hobby entity);
}
