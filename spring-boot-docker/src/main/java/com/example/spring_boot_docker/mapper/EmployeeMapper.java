package com.example.spring_boot_docker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.model.Employee;
import com.example.spring_boot_docker.service.HobbyService;
import com.example.spring_boot_docker.service.PrefectureService;

@Mapper(componentModel = "spring", uses = {PrefectureService.class, HobbyService.class})
public interface EmployeeMapper {

    @Mapping(target = "prefecture", source = "prefectureId")
    @Mapping(target = "hobbies", source = "hobbyIds")
    @Mapping(target = "employeeId", ignore = true)
    Employee toEntity(EmployeeDto dto);

    @Mapping(source = "prefecture.prefectureId", target = "prefectureId")
    @Mapping(source = "hobbies", target = "hobbyIds")
    EmployeeDto toDto(Employee entity);

    @Mapping(target = "prefecture", source = "prefectureId")
    @Mapping(target = "hobbies", source = "hobbyIds")
    @Mapping(target = "employeeId", ignore = true)
    void updateEntityFromDto(EmployeeDto dto, @MappingTarget Employee entity);
}