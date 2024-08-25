package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);
    
    List<Task> findTasksByTitleContaining(String title);

    Task createTask(Task task);

    Optional<Task> updateTask(Long id, Task taskDetails);

    boolean deleteTask(Long id);
}
