package task_api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
class TaskController {
    
    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    List<Task> all() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    @GetMapping("/tasks/{id}")
    Task one(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));
    }
}

