package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.specification.TaskSpecification;

import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(taskDetails.getTitle());
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setStatus(taskDetails.getStatus());
            existingTask.setDueDate(taskDetails.getDueDate());
            return taskRepository.save(existingTask);
        });
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.delete(task);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Task> findTasksByTitleContaining(String title) {
        return taskRepository.findTasksByTitleContaining(title);
    }

    @Override
    public List<String> getAllTaskTitles() {
        List<Task> tasks = taskRepository.findAll();
        
        return tasks.stream()
                    .map(Task::getTitle)
                    .collect(Collectors.toList());
    }

    @Override
    public List<Task> findTasksByDescriptionContaining(String description) {
        Specification<Task> spec = TaskSpecification.hasDescriptionLike(description);
        return taskRepository.findAll(spec);
    }
}
