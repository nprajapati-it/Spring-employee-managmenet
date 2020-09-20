package com.nprajapati.emanagment.controller;

import java.util.List;
import java.util.Optional;

import com.nprajapati.emanagment.model.Department;
import com.nprajapati.emanagment.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

   private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @RequestMapping("/departments/{id}")
    public Optional<Department> getDepartment(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
    public void updateDepartment(@RequestBody Department d, @PathVariable Long id){
        departmentService.updateDepartment(d, id);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.DELETE)
    public void deleteAllDepartments(){
        departmentService.deleteAllDepartment();
    }

    @RequestMapping(value = "departments/{id}", method = RequestMethod.DELETE)
    public void deleteDepartmentByID(@RequestBody Department d){
        departmentService.deleteDepartmentByID(d);
    }

}
