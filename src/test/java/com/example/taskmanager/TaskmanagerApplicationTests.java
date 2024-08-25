package com.example.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.taskmanager.repository.TaskRepository;

@SpringBootTest
public class TaskmanagerApplicationTests {
    
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void whenContextLoads_thenServiceISNotNull() {
        assertThat(taskRepository).isNotNull();
    }
}
