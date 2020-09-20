package com.nprajapati.emanagment.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emp_id;

    @Column(name = "employee_name")
    private String emp_name;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "employee_dob")
    private Date emp_dob;

    @Column(name = "employee_salary")
    private Long emp_salary;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String emp_name, Date emp_dob, Long emp_salary, Department department) {
        this.emp_name = emp_name;
        this.emp_dob = emp_dob;
        this.emp_salary = emp_salary;
        this.department = department;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Date getEmp_dob() {
        return emp_dob;
    }

    public void setEmp_dob(Date emp_dob) {
        this.emp_dob = emp_dob;
    }

    public Long getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(Long emp_salary) {
        this.emp_salary = emp_salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
