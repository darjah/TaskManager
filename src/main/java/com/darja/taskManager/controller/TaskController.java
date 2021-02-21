package com.darja.taskManager.controller;

import com.darja.taskManager.dto.TaskDTO;
import com.darja.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping
    public List<TaskDTO> getTasks() {
        return service.getTasks();
    }

    @PostMapping
    public List<TaskDTO> createTask(@RequestBody TaskDTO newTask) {
        return service.createTask(newTask);
    }

    @DeleteMapping("/{id}")
    public List<TaskDTO> deleteTask(@PathVariable("id") int id) {
        return service.deleteTask(id);
    }
}
