package task_api.service;

import task_api.repository.TaskRepository;
import task_api.models.Task;
import task_api.exceptions.TaskNotFoundException;
import task_api.exceptions.IllegalStateException;
import task_api.exceptions.MissingFieldsException;
import java.util.Optional;

import org.springframework.stereotype.Service; 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task findById(UUID id) throws TaskNotFoundException {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
    public Optional<Task> findByIdUpdate(UUID id) {
        return taskRepository.findById(id);
    }

    public Page<Task> getTasks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return taskRepository.findAll(pageable);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task startTask(UUID taskId) {
        Task task = findById(taskId);

        if (task.getStatus_id() == Task.Status_id.in_progress) {
            throw new IllegalStateException("Task is already in progress");
        }

        task.setStatus_id(Task.Status_id.in_progress);
        return taskRepository.save(task);
    }

    public Task stopProgress(UUID taskId) {
        Task task = findById(taskId);

        if (task.getStatus_id() != Task.Status_id.in_progress) {
            throw new IllegalStateException("Task is not in progress to stop");
        }

        task.setStatus_id(Task.Status_id.open);
        return taskRepository.save(task);
    }

    public Task closeTask(UUID taskId) {
        Task task = findById(taskId);

        task.setStatus_id(Task.Status_id.closed);
        return taskRepository.save(task);
    }

    public Task reopenTask(UUID taskId) {
        Task task = findById(taskId);

        if (task.getStatus_id() != Task.Status_id.closed) {
            throw new IllegalStateException("Task is not closed to reopen");
        }

        task.setStatus_id(Task.Status_id.open);
        return taskRepository.save(task);
    }

    public Task updateTask(UUID id, Task updatedTask) {
        Task task = findById(id);

        if (updatedTask.getSubject() == null || updatedTask.getDescription() == null) {
            throw new MissingFieldsException("Subject and Description must not be null");
        }

        task.setSubject(updatedTask.getSubject());
        task.setDescription(updatedTask.getDescription());

        return taskRepository.save(task);
    }

    public String deleteTask(UUID id) {
        Task task = findById(id);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.delete(task);

        return "Task task deleted successfully";
    }
}
