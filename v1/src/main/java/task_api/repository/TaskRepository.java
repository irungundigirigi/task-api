package task_api.repository;

import task_api.models.Task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface provides access to data via inbult methods.
 * eg findAll() findById()
 */

public interface TaskRepository extends JpaRepository<Task, UUID> {
}