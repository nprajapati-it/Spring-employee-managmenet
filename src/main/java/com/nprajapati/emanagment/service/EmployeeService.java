package com.nprajapati.emanagment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nprajapati.emanagment.model.Employee;
import com.nprajapati.emanagment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees()
    {
        List<Employee> result = (List<Employee>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Employee>();
        }
    }

    public Employee getEmployeeById(Long id)
    {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    public Employee createOrUpdateEmployee(Employee entity)
    {
        if(entity.getEmp_id()  == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<Employee> employee = repository.findById(entity.getEmp_id());

            if(employee.isPresent())
            {
                Employee newEntity = employee.get();
                newEntity.setEmp_name(entity.getEmp_name());
                newEntity.setEmp_dob(entity.getEmp_dob());
                newEntity.setEmp_salary(entity.getEmp_salary());
                newEntity.setDepartment(entity.getDepartment());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteEmployeeById(Long id)
    {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            System.out.println("Nothing");
        }
    }
}

