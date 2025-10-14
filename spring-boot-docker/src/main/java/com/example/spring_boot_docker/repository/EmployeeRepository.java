package com.example.spring_boot_docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.model.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}

