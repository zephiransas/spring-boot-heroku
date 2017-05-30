package com.example.demo.service;


import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void prepare() {
        departmentRepository.deleteAll();
        employeeRepository.deleteAll();

        Department department = Department.builder()
                .name("部署1")
                .build();
        department = departmentRepository.save(department);

        Employee employee1 = Employee.builder()
                .name("テスト1")
                .email("test1@example.com")
                .departmentId(department.getId())
                .build();
        employeeRepository.save(employee1);

        Employee employee2 = Employee.builder()
                .name("テスト2")
                .email("test2@example.com")
                .departmentId(department.getId())
                .build();
        employeeRepository.save(employee2);


        Department department2 = Department.builder()
                .name("部署2")
                .build();
        department2 = departmentRepository.save(department2);

        Employee employee3 = Employee.builder()
                .name("テスト3")
                .email("test3@example.com")
                .departmentId(department2.getId())
                .build();
        employeeRepository.save(employee3);

    }

}
