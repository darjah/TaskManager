package com.darja.taskManager.service.impl;

import com.darja.taskManager.dto.TaskDTO;
import com.darja.taskManager.entity.Task;
import com.darja.taskManager.repository.TaskRepository;
import com.darja.taskManager.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repo;

    @Override
    public List<TaskDTO> getTasks() {
        return repo.findAll()
                   .stream()
                   .map(this::mapToDTO)
                   .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> createTask(TaskDTO task) {
        repo.save(mapToEntity(task));
        return getTasks();
    }

    @Override
    public List<TaskDTO> deleteTask(int id) {
        log.debug("Deleted task with id ", id);
        repo.deleteById(id);
        return getTasks();
    }

    @Override
    public String ping() {
        return "service pong";
    }

    private TaskDTO mapToDTO(Task task) {
        return TaskDTO.builder()
                      .userId(task.getUserId())
                      .id(task.getId())
                      .title(task.getTitle())
                      .priority(task.getPriority())
                      .createdAt(task.getCreatedAt())
                      .deadline(task.getDeadline())
                      .build();
    }

    private Task mapToEntity(TaskDTO task) {
        return Task.builder()
                      .userId(task.getUserId())
                      .title(task.getTitle())
                      .priority(task.getPriority())
                      .createdAt(LocalDateTime.now())
                      .deadline(task.getDeadline())
                      .build();
    }
}
