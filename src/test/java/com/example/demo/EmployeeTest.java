package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    @Transactional
    public void test() throws Exception {
        repository.deleteAll();

        Employee employee = Employee.builder()
                .name("テスト")
                .email("test@example.com")
                .departmentId(1)
                .build();
        repository.save(employee);

        List<Employee> employees = repository.findAll();
        Assert.assertThat(employees.size(), Matchers.is(1));
    }

}
