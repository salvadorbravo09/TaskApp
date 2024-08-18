package com.alejandro.task.services;

import com.alejandro.task.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    void deleteById(Long id);
}
