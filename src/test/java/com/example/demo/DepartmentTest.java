package com.example.demo;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.hibernate.Hibernate;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {

    @Autowired
    DepartmentRepository repository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @Ignore
    public void test() throws Exception {
        repository.deleteAll();
        employeeRepository.deleteAll();

        Department department = Department.builder()
                .name("部署1")
                .build();
        department = repository.saveAndFlush(department);

        Employee employee1 = Employee.builder()
                .name("テスト1")
                .email("test1@example.com")
                .departmentId(department.getId())
                .department(department)
                .build();
        employeeRepository.saveAndFlush(employee1);

        Employee employee2 = Employee.builder()
                .name("テスト2")
                .email("test2@example.com")
                .departmentId(department.getId())
                .department(department)
                .build();
        employeeRepository.saveAndFlush(employee2);

        System.out.println(department.getEmployees().size());

        List<Department> departments = repository.findAll();

        assertThat(departments.size(), is(1));

        Department dep = departments.get(0);
        assertThat(dep.getEmployees().size(), is(2));

    }

}
