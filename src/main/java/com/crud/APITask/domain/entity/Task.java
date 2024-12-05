package com.crud.APITask.domain.entity;

import com.crud.APITask.enums.TaskStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;


}
