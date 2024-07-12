package task_api;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/api/v1")
public class TaskController {
    
    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
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
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    /**
     * This method is called when a GET request is made
     * URL: {hostname}/api/v1/tasks/{id}
     * Purpose: Fetches specific task table with id {id}
     * @return Task
    */
    @GetMapping("/tasks/{id}")
    public Task getByID(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        if(task.isPresent()) {
            return task.get();

        }
            //.orElseThrow(() -> new TaskNotFoundException(id));
        return null;
    }
}

