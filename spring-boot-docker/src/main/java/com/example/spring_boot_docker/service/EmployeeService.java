package com.example.spring_boot_docker.service;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.mapper.EmployeeMapper;
import com.example.spring_boot_docker.model.Employee;
import com.example.spring_boot_docker.repository.EmployeeRepository;

@Service
public class EmployeeService {

@Autowired
private EmployeeRepository employeeRepository;
private EmployeeMapper employeeMapper;

public void saveEmployee(EmployeeDto employeeDto) {
    employeeRepository.save(employeeMapper.ToEntity(employeeDto));
}

public EmployeeDto findEmployee(Long Id) {
    Employee employee =
    employeeRepository.findById(Id).orElseThrow();
    return employeeMapper.ToDto(employee);
}

public void deleteEmployee(Long Id){
    employeeRepository.delete(employeeMapper.ToEntity(findEmployee(Id)));
}

public void updateEmployee(Long Id,String name,Integer ege,Integer  sex,Integer adress1,String adress2,Integer hobby,String intro,Blob image){
    Employee employee =employeeMapper.ToEntity(findEmployee(Id));

    employee.setName(name);
    employee.setEge(ege);
    employee.setSex(sex);
    employee.setAdress1(adress1);
    employee.setAdress2(adress2);
    employee.setHobby(hobby);
    employee.setIntro(intro);
    employee.setImage(image);

    employeeRepository.save(employee);
}


}
