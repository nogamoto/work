package com.example.spring_boot_docker.mapper;

import org.mapstruct.Mapper;

import com.example.spring_boot_docker.dto.PrefectureDto;
import com.example.spring_boot_docker.model.Prefecture;

@Mapper(componentModel = "spring")
public interface PrefectrueMapper {

    Prefecture  ToDto(PrefectureDto dto);
    PrefectrueMapper ToEntity(Prefecture entity);

}
