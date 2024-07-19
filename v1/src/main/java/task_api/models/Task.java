package task_api.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;


/**
 * An entity class that defines the task object
 * Maps to a table in the database.
 */

@Entity
@Data
@Table(name = "tasks")
@EqualsAndHashCode(callSuper=false)
public class Task extends BaseModel {
    

    private String object;

    @NotNull
    private UUID user_id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Task_priority task_priority;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status_id status_id;

    @NotNull
    @Size(min = 1, max = 40)
    private String subject;

    @NotNull
    @Size(min = 1, max = 1000)
    private String description;

    @NotNull
    @Size(max = 50)
    private String due_date;

    public Task() {
        this.object = this.getClass().getSimpleName(); 
    }

    public enum Task_priority {
        high,
        normal,
        low
    }

    public enum Status_id {
        open,
        in_progress,
        closed
    }
}
