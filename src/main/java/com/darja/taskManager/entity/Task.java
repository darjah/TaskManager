package com.darja.taskManager.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity // This tells Hibernate to make a table out of this class
public class Task {
    @NonNull
    private String userId;
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    private String title;
    @NonNull
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    @Enumerated(EnumType.STRING)
    private TaskPrio priority;
}
