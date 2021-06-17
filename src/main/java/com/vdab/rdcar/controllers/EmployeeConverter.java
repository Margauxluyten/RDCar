package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class EmployeeConverter implements Formatter<Employee> {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Employee parse(String s, Locale locale) throws ParseException {
        return employeeService.findById(Long.valueOf(s));
    }

    @Override
    public String print(Employee employee, Locale locale) {
        return (employee != null ? String.valueOf(employee.getId()) : "");
    }
}
