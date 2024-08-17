package com.alejandro.task.repositories;

import com.alejandro.task.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
