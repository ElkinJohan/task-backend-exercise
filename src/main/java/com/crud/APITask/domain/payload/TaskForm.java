package com.crud.APITask.domain.payload;

import com.crud.APITask.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskForm {
    private String title;
    private String description;
    private LocalDateTime eta;
}
