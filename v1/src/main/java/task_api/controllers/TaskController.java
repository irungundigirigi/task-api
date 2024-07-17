package task_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import task_api.service.TaskService;
import task_api.exception.TaskNotFoundException;
import org.springframework.data.domain.Page;

import task_api.models.Task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/api/v1")
public class TaskController {
    
    @Autowired
    TaskService taskService;

    /**
     * This method is called when a POST request is made
     * URL: {hostname}/api/v1/tasks
     * Purpose: Adds a task to the tasks table
     * @return Created Task
    */
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok().body(taskService.saveTask(savedTask));
    }

    /**
     * This method is called when a GET request is made
     * URL: {hostname}/api/v1/tasks
     * Purpose: Fetches all the tasks in the tasks table
     * @return List of Tasks
    */
    @GetMapping("/tasks")
    public ResponseEntity<Page<Task>> getAllTasks(
        @RequestParam(defaultValue = "0") int pageNo,
        @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<Task> tasks = taskService.getTasks(pageNo, pageSize);
        return ResponseEntity.ok().body(tasks);
    }

    /**
     * This method is called when a GET request is made
     * URL: {hostname}/api/v1/tasks/{id}
     * Purpose: Fetches specific task table with id {id}
     * @return Task
    */
    @GetMapping("/tasks/{id}")
    /** public Task getByID(@PathVariable UUID id) {
        Optional<Task> task = taskService.findById(id);
        return task.orElseThrow(() -> new TaskNotFoundException(id));
    */
    public ResponseEntity<?> getByID(@PathVariable UUID id) {
    
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok)
            .orElseThrow(() -> new TaskNotFoundException(id));
  
    
    }
}

