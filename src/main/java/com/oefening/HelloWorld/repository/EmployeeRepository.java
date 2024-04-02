package com.oefening.HelloWorld.repository;

import com.oefening.HelloWorld.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Iterable<Employee> findByName(String name);
}
