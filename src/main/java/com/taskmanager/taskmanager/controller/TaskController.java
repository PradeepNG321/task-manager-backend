package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @PostMapping("/create")
    public String createTask(@RequestBody Task task) {
        tasks.add(task);
        return "Task created: " + task.getTitle();
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PutMapping("/updateStatus")
    public String updateStatus(@RequestBody Task updatedTask) {
        for (Task t : tasks) {
            if (t.getTitle().equals(updatedTask.getTitle())) {
                t.setStatus(updatedTask.getStatus());
                return "Task updated";
            }
        }
        return "Task not found";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        int completed = 0;
        int pending = 0;

        for (Task t : tasks) {
            if ("Completed".equalsIgnoreCase(t.getStatus())) {
                completed++;
            } else {
                pending++;
            }
        }

        return "Completed: " + completed + ", Pending: " + pending;
    }
}