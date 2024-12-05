package com.crud.APITask.service;


import com.crud.APITask.domain.dto.TaskDTO;
import com.crud.APITask.domain.entity.Task;
import com.crud.APITask.domain.payload.TaskForm;
import com.crud.APITask.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskDTO create(TaskForm taskForm);

    List<Task> getAllTasks();

    List<Task> getAllByTaskStatus(TaskStatus status);

    void updateTaskFinished(Long id);

    void deleteById(Long id);
}
