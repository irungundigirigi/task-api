package task_api.models;

import java.util.List;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotNull;
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
@EqualsAndHashCode(callSuper=false)
public class User extends BaseModel {

    private String object;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    public User() {
        this.object = this.getClass().getSimpleName(); 
    }
    
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Task> tasks;
}



