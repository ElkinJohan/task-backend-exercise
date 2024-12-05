package com.crud.APITask.repository;

import com.crud.APITask.domain.entity.Task;
import com.crud.APITask.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    /**
     * update task t set t.finished = true where t.id = 1
     * */
    @Modifying
    @Query(value = "update Task t set t.finished = true where t.id = :id")
    void changeTaskFinished(@Param("id") Long id);
}
