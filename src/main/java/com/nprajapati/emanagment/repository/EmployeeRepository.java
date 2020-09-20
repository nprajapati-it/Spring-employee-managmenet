package com.nprajapati.emanagment.repository;

import com.nprajapati.emanagment.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
