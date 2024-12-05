package com.crud.APITask.service.impl;

import com.crud.APITask.domain.entity.Task;
import com.crud.APITask.domain.mapper.TaskMapper;
import com.crud.APITask.domain.payload.TaskForm;
import com.crud.APITask.enums.TaskStatus;
import com.crud.APITask.exceptions.ToDoException;
import com.crud.APITask.repository.TaskRepository;
import com.crud.APITask.service.TaskService;
import com.crud.APITask.domain.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO create(TaskForm taskForm) {

        Task task = new Task();

        task.setTitle(taskForm.getTitle());
        task.setDescription(taskForm.getDescription());
        task.setEta(taskForm.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        this.taskRepository.save(task);

        TaskDTO responseDTO = taskMapper.map(task);

        return responseDTO;
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public List<Task> getAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Override
    @Transactional
    public void updateTaskFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.changeTaskFinished(id);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }
}
