package com.alejandro.task.controllers;

import com.alejandro.task.entities.Task;
import com.alejandro.task.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/find")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Optional<Task> optionalTask = taskService.findById(id);
        if (optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = taskService.findById(id);
        if (optionalTask.isPresent()) {
            taskService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
