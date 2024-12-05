package com.crud.APITask.domain.dto;

import com.crud.APITask.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
