package task_api.models;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.util.UUID;


/**
 * An entity class that defines the task object
 * Maps to a table in the database.
 */

@Entity
@Data
@Table(name = "tasks")
public class Task extends BaseModel {
    
    private UUID user_id;
    private String object;
    @Enumerated(EnumType.STRING)
    private Task_priority task_priority;
    private Integer status_id;
    private String subject;
    private String description;
    private String due_date;

    public Task() {
        this.object = this.getClass().getSimpleName(); 
    }

    public enum Task_priority {
        High,
        Medium,
        Low
    }
}
