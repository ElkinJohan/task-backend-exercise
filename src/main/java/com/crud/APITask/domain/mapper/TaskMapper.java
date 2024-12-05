package com.crud.APITask.domain.mapper;

import com.crud.APITask.domain.dto.TaskDTO;
import com.crud.APITask.domain.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements IMapper<Task, TaskDTO>{

    @Override
    public TaskDTO map(Task in) {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(in.getId());
        taskDTO.setTitle(in.getTitle());
        taskDTO.setDescription(in.getDescription());
        taskDTO.setEta(in.getEta());
        taskDTO.setCreatedDate(in.getCreatedDate());
        taskDTO.setFinished(in.isFinished());
        taskDTO.setTaskStatus(in.getTaskStatus());

        return taskDTO;
    }
}
