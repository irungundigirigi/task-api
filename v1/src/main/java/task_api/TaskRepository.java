package task_api;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface provides access to data via inbult methods.
 * eg findAll() findById()
 */

interface TaskRepository extends JpaRepository<Task, Long> {

}