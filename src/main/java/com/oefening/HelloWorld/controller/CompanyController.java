package com.oefening.HelloWorld.controller;

import com.oefening.HelloWorld.model.Company;
import com.oefening.HelloWorld.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/findall")
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @PostMapping("/create")
    public Company create(@RequestBody Company company) {
        return companyRepository.save(company);
    }
}
