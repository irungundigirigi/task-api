package task_api;

import java.util.List;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;




@Entity
@Data
@Table(name = "users")
public class User extends BaseModel {
    
    private String username;
    private String password;
    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //private List<Todo> todos;
}
