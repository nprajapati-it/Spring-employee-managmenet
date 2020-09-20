package com.nprajapati.emanagment.service;

import java.util.List;
import java.util.Optional;

import com.nprajapati.emanagment.model.Department;
import com.nprajapati.emanagment.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){
        List<Department> depts = (List<Department>)departmentRepository.findAll();
        return depts;
    }

    public Optional<Department> getDepartment(Long id){
        return departmentRepository.findById(id);
    }

    public void addDepartment(Department d) {
        departmentRepository.save(d);
    }

    public void updateDepartment(Department d, Long id){
        if(id == d.getDept_id()) {
            departmentRepository.save(d);
        }
    }

    public void deleteAllDepartment(){
        departmentRepository.deleteAll();
    }

    public void deleteDepartmentByID(Department dept){
        departmentRepository.delete(dept);
    }

}
