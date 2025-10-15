package com.example.spring_boot_docker.mapper;

import org.mapstruct.Mapper;

import com.example.spring_boot_docker.dto.PrefectureDto;
import com.example.spring_boot_docker.model.Prefecture;

@Mapper(componentModel = "spring")
public interface PrefectrueMapper {

    PrefectureDto  ToDto(Prefecture entity);
    Prefecture ToEntity(PrefectureDto dto);

}
