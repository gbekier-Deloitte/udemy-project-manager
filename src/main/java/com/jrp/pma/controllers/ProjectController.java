package com.jrp.pma.controllers;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRep;

    @GetMapping
    public String displayProjects(Model model)
    {
        List<Project> projects = proRep.findAll();
        model.addAttribute("projectList",projects);
        return "projects/projects-list";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model)
    {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "projects/projects-new";
    }

    //handles saving to database
    @PostMapping("/save")
    public String createProject(Project project, Model model)
    {
        proRep.save(project);

        //redirect used for prevention of duplicate submissions
        return "redirect:/projects";
    }
}
