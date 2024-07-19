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
import org.springframework.web.bind.annotation.PatchMapping;
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
            task.getDue_date() == null ||
            task.getStatus_id() == null || task.getSubject() == null ||
            task.getTask_priority() == null || task.getUser_id() == null ) {
            throw new MissingFieldsException("One or more required fields are missing");
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

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<Task> getByID(@PathVariable UUID id, @RequestBody Task updatedTask) {
        Task task = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getByID(@PathVariable UUID id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return "Task " + id + " deleted successfully";
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
    public ResponseEntity<?> reopenTask(@PathVariable UUID id) {
        Task reopenedTask = taskService.reopenTask(id);
        return ResponseEntity.ok(reopenedTask);
    }
}

