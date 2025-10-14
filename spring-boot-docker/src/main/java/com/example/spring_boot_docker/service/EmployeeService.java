package com.example.spring_boot_docker.service;

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

public void updateEmployee(Long Id,Employee employee){
    Employee employee2 =new Employee(
            employee.Id,
            employee.getName(),
            employee.getEge(),
            employee.getSex(),
            employee.getAdress1(),
            employee.getAdress2(),
            employee.getHobby(),
            employee.getIntro(),
            employee.getImage()
    )
    employeeRepository.save();
}


}
