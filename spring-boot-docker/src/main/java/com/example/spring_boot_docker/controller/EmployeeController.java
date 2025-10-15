package com.example.spring_boot_docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping("/input")
    public String getMethodName(Model model) {
        model.addAttribute("employee,new EmployeeDto()");
        return "employeeInput";
    }

    @GetMapping("/List")
    public String getEmployeeList(Model model) {
        List<EmployeeDto> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        return "employeeList";
    }

    @PostMapping("/Register")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.saveEmployee(employeeDto);
        return "redirect:/employee/deteail?id=" + employeeDto.getId();
    }

    @GetMapping("/deteail")
    public String findEmployee(@RequestParam Long id, Model model) {
        EmployeeDto employeeDto = employeeService.findEmployee(id);
        model.addAttribute("employee", employeeDto);
        return "employeeDetail";
    }

}
