package task_api.dto;

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


@Data
public class TaskUpdateDTO {

    @Size(min = 5, max = 40)
    private String subject;
    @Size(min = 10, max = 1000)
    private String description;
}
