package com.crud.APITask.controller;

import com.crud.APITask.domain.dto.TaskDTO;
import com.crud.APITask.domain.entity.Task;
import com.crud.APITask.domain.payload.TaskForm;
import com.crud.APITask.enums.TaskStatus;
import com.crud.APITask.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskForm taskForm){
        try {
            return ResponseEntity.ok(this.taskService.create(taskForm));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Task> getAll(){
        return this.taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.getAllByTaskStatus(status);
    }

    @PatchMapping("/change_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
