package com.example.spring_boot_docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.mapper.EmployeeMapper;
import com.example.spring_boot_docker.model.Employee;
import com.example.spring_boot_docker.model.Hobby;
import com.example.spring_boot_docker.model.Prefecture;
import com.example.spring_boot_docker.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PrefectureService PrefectureService;
    @Autowired
    private HobbyService HobbyService;

    public void saveEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.toEntity(employeeDto));
    }

    public List<EmployeeDto> getEmployeeList() {
        return employeeRepository.findAll().stream().map(employee -> employeeMapper.toDto(employee)).toList();
    }

    public EmployeeDto findEmployee(Long Id) {
        Employee employee = employeeRepository.findById(Id).orElseThrow();
        return employeeMapper.toDto(employee);
    }

    public void deleteEmployee(Long Id) {
        employeeRepository.delete(employeeMapper.toEntity(findEmployee(Id)));
    }

    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(findEmployee(employeeDto.getEmployeeId()));

        Prefecture  prefecture = PrefectureService.findPrefecture(employeeDto.getPrefectureId());
        List<Hobby> hobby = HobbyService.findHobby(employeeDto.getHobbyIds());
        employee.setName(employeeDto.getName());
        employee.setEge(employeeDto.getEge());
        employee.setSex(employeeDto.getSex());
        employee.setPrefecture(prefecture);
        employee.setAddress(employeeDto.getAddress());
        employee.setHobbies(hobby);
        employee.setIntro(employeeDto.getIntro());
        employee.setImage(employeeDto.getImage());

        employeeRepository.save(employee);
    }

}
