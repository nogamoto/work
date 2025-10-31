package com.example.spring_boot_docker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.spring_boot_docker.dto.PrefectureDto;
import com.example.spring_boot_docker.model.Prefecture;

@Mapper(componentModel = "spring")
public interface PrefectureMapper {

    @Mapping(target = "employees", ignore = true)
    Prefecture toEntity(PrefectureDto dto);

    PrefectureDto toDto(Prefecture entity);

}
