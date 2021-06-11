package com.vdab.rdcar.services;

import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployee() {
        return employeeRepository.getEmployee();
    }
}
