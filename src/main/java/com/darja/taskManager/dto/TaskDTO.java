package com.darja.taskManager.dto;

import com.darja.taskManager.entity.TaskPrio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDTO {
    private String userId;
    private int id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private TaskPrio priority;
}
