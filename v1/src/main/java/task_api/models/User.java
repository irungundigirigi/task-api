package task_api.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.UUID;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User extends BaseModel {

    private String username;
    private String password;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Task> tasks;
}


