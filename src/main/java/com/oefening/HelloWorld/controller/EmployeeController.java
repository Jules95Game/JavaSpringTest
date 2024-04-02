package com.oefening.HelloWorld.controller;

import com.oefening.HelloWorld.model.Company;
import com.oefening.HelloWorld.model.Employee;
import com.oefening.HelloWorld.repository.CompanyRepository;
import com.oefening.HelloWorld.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/findall")
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/findbyname/{test}")
    public Iterable<Employee> findByName(@PathVariable("test") String name) {
        return employeeRepository.findByName(name);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PatchMapping("/addcompany/{com}/{em}")
    public Employee addCompany(@PathVariable("com") Long com, @PathVariable("em") Long em) {
        Company company = companyRepository.findById(com).get();
        Employee employee = employeeRepository.findById(em).get();
        employee.setCompany(company);
        return employeeRepository.save(employee);
    }
}
