package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private List<Project> projects = new ArrayList<>();

    @PostMapping("/create")
    public String createProject(@RequestBody Project project) {
        projects.add(project);
        return "Project created: " + project.getName();
    }

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projects;
    }
}