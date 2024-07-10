package task_api;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import java.time.LocalDateTime;

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

    public Task() {
    }
/** 
    public String getObject() {
        return object;
    }

    public String getTask_priority() {
        return task_priority;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getDue_date() {
        return due_date;
    }
    public void setObject(String object) {
        this.object = object;
    }

    public void setTask_priority(String task_priority) {
        this.task_priority = task_priority;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
*/
}
