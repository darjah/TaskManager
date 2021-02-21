package com.darja.taskManager.service;

import com.darja.taskManager.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();
    List<TaskDTO> createTask(TaskDTO task);
    List<TaskDTO> deleteTask(int id);
    String ping();
}
