package task_api.service;

import task_api.repository.TaskRepository;
import task_api.models.Task;

import org.springframework.stereotype.Service; 

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task>  getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return savedTask;
    }

    public Optional<Task> findById(UUID id) {
        return taskRepository.findById(id);
    }
}

