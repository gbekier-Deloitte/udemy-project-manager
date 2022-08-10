package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRep;

    @GetMapping
    public String displayEmoployees(Model model)
    {
        List<Employee> employees = empRep.findAll();
        model.addAttribute("employeesList",employees);
        return "employees/employees-list";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model)
    {
        Employee anEmpployee = new Employee();
        model.addAttribute("employee",anEmpployee);
        return "employees/employees-new";
    }

    @PostMapping("/save")
    public String addEmployee(Employee employee)
    {
        empRep.save(employee);

        return "redirect:/employees";
    }
}
