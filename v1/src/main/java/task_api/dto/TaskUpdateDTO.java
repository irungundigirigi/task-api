package task_api.dto;

import lombok.Data;
import jakarta.validation.constraints.Size;



@Data
public class TaskUpdateDTO {

    @Size(min = 5, max = 40)
    private String subject;
    @Size(min = 10, max = 1000)
    private String description;
}
