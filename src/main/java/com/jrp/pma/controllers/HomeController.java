package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController
{

    @Autowired
    ProjectRepository proRep;
    @Autowired
    EmployeeRepository empRep;

    @GetMapping("/")
    public String displayHome(Model model)
    {
        List<Project> projectsList = proRep.findAll();
        List<Employee> employeesList = empRep.findAll();
        model.addAttribute("projectsList", projectsList);
        model.addAttribute("employeesList", employeesList);
        return "main/home";
    }
}
