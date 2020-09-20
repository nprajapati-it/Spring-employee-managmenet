package com.nprajapati.emanagment.model;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dept_id;

    @Column(name = "department_name")
    private String dept_name;

    public Department(String dept_name) {
        this.dept_name = dept_name;
    }

    public Department() {}

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
