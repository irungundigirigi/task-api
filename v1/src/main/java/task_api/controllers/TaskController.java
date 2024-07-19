package task_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import task_api.service.TaskService;
import task_api.exceptions.TaskNotFoundException;
import task_api.exceptions.ResourceAlreadyExistsException;
import task_api.exceptions.MissingFieldsException;
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

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        if (task.getDescription() == null || task.getDescription().trim().isEmpty() ||
            task.getDue_date() == null || task.getObject() == null ||
            task.getStatus_id() == null || task.getSubject() == null ||
            task.getTask_priority() == null || task.getUser_id() == null ||
            task.getId() == null) {
            throw new MissingFieldsException("One or more required fields are missing");
        }

        Task existingTask = taskService.findById(task.getId());
        if (existingTask != null) {
            throw new ResourceAlreadyExistsException("Task with ID " + task.getId() + " already exists.");
        }

        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok().body(taskService.saveTask(savedTask));
    }

    @GetMapping("/tasks")
    public ResponseEntity<Page<Task>> getAllTasks(
        @RequestParam(defaultValue = "0") int pageNo,
        @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<Task> tasks = taskService.getTasks(pageNo, pageSize);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getByID(@PathVariable UUID id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }
    
    @GetMapping("/tasks/{id}/start_progress")
    public ResponseEntity<?> startTask(@PathVariable UUID id) {
        Task startedTask = taskService.startTask(id);
        return ResponseEntity.ok(startedTask);
    }

      
    @GetMapping("/tasks/{id}/stop_progress")
    public ResponseEntity<?> stopProgress(@PathVariable UUID id) {
        Task stoppedTask = taskService.stopProgress(id);
        return ResponseEntity.ok(stoppedTask);
    }
      
    @GetMapping("/tasks/{id}/close")
    public ResponseEntity<?> closeTask(@PathVariable UUID id) {
        Task closedTask = taskService.closeTask(id);
        return ResponseEntity.ok(closedTask);
    }

    @GetMapping("/tasks/{id}/reopen")
    public ResponseEntity<?> reOpenTask(@PathVariable UUID id) {
        Task reopenedTask = taskService.reopenTask(id);
        return ResponseEntity.ok(reopenedTask);
    }

}

