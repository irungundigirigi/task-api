package task_api.service;

import task_api.repository.TaskRepository;
import task_api.models.Task;
import task_api.exception.TaskNotFoundException;

import org.springframework.stereotype.Service; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Page<Task>  getTasks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return taskRepository.findAll(pageable);
    }

    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return savedTask;
    }

    public Optional<Task> findById(UUID id) {
        return taskRepository.findById(id);
    }
}

