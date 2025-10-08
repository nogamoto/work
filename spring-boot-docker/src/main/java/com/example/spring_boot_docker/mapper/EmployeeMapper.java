package com.example.spring_boot_docker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee ToEntity(EmployeeDto dto);

    EmployeeDto ToDto(Employee entity);

    void UpdateEntityFromDto(EmployeeDto dto,@MappingTarget Employee entity);
}