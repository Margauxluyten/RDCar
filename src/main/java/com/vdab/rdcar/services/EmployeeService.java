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

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployee();
    }

    public void saveEmployee(Employee newEmployee) {

        employeeRepository.saveEmployee(newEmployee);
    }


    public Employee findById(long id)  {
        return employeeRepository.findByID(id);
    }

    public void updateEmployee(Employee employee) {
      employeeRepository.updateEmployee(employee);
    }

    public void removeEmployee(long id) {
        employeeRepository.removeEmployee(id);
    }
}
