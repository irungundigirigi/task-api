package task_api;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * An entity class that defines the task object
 * Maps to a table in the database.
 */

@Entity
@Data
public class Task extends BaseModel {

    private String object;
    private String task_priority;
    private Integer status_id;
    private String subject;
    private String description;
    private String due_date;

}
