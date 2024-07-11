package task_api;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
public class Task extends BaseEntity {

    private String object;
    private String task_priority;
    private Integer status_id;
    private String subject;
    private String description;
    private String due_date;

}
