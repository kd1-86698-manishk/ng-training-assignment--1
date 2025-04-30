package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojo.Task;
import com.project.repository.TaskRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
@Autowired
private TaskRepository taskRepo;

@GetMapping
public List<Task> getAllTasks() {
return taskRepo.findAll();
}

@PostMapping
public Task createTask(@RequestBody Task task) {
return taskRepo.save(task);
}

@PutMapping("/{id}")
public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
return taskRepo.findById(id).map(task -> {
task.setTitle(updatedTask.getTitle());
task.setCompleted(updatedTask.isCompleted());
return ResponseEntity.ok(taskRepo.save(task));
}).orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
if (taskRepo.existsById(id)) {
taskRepo.deleteById(id);
return ResponseEntity.ok().build();
}
return ResponseEntity.notFound().build();
}
}