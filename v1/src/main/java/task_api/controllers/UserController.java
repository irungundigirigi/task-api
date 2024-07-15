package task_api.controllers;

import task_api.repository.UserRepository;
import task_api.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepo;

    @GetMapping("/api/v1/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/api/v1/users")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping("/api/v1/update/{id}")
    public String updateUser(@PathVariable UUID id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        userRepo.save(updatedUser);
        return "Updated";
    }
    

    @DeleteMapping("/api/v1/users/{id}")
    public String deleteUser(@PathVariable UUID id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with id: "+id;
    }
}