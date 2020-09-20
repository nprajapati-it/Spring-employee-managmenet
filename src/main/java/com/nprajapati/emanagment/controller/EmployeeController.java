package com.nprajapati.emanagment.controller;

import com.nprajapati.emanagment.model.Employee;
import com.nprajapati.emanagment.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping
    public String getAllEmployees(Model model)
    {
        List<Employee> list = service.getAllEmployees();

        model.addAttribute("employees", list);
        return "list-employees";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
    {
        if (id.isPresent()) {
            Employee entity = service.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "add-edit-employee";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
    {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(Employee employee)
    {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }

}
