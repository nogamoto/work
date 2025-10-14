package com.example.spring_boot_docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

@Autowired
private EmployeeService employeeService;

@GetMapping("/getEmp")
public EmployeeDto getEmployee(@RequestParam Long id) {
    return employeeService.findEmployee(id);
}

@PostMapping("/saveEmp")
public void saveEmployee(@RequestBody EmployeeDto employeeDto) {
employeeService.saveEmployee(employeeDto);
}


}
