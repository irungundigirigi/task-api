package task_api.controllers;

import task_api.MockMVCBaseClass;
import task_api.models.Task;
import task_api.dto.TaskUpdateDTO;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Disabled;
import static org.hamcrest.Matchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


class ControllerTest extends MockMVCBaseClass {
  
    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task();

        task.setUser_id(UUID.fromString("123e4567-e89b-12d3-a456-556642440015"));
        task.setTask_priority(Task.Task_priority.high);
        task.setStatus_id(Task.Status_id.open);
        task.setSubject("Spring boot testing - ");
        task.setDescription("Testing POST /api/v1/tasks");
        task.setDue_date("2024-07-19T12:00:00");

        String task_ = objMapper.writeValueAsString(task);

        mockMvc.perform(post("/api/v1/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(task_)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    } 

    @Test
    public void testGetTasks() throws Exception {
        mockMvc.perform(get("/api/v1/tasks")
            .param("pageNo", "1")
            .param("pageSize", "5")
        ) 
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray())
        .andExpect(MockMvcResultMatchers.jsonPath("$.size").value(5))
        .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(5));
    }

    @Test
    public void testGetTaskById() throws Exception {

        UUID id  = UUID.fromString("cb5425f0-ed68-4336-bf6b-c2ff03c017a5");
        mockMvc.perform(get("/api/v1/tasks/{id}", id))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id.toString()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.object").value("Task"));
    }

    @Test
    public void testUpdateTask() throws Exception {

        UUID id  = UUID.fromString("cb5425f0-ed68-4336-bf6b-c2ff03c017a5");

        TaskUpdateDTO task = new TaskUpdateDTO();
        task.setSubject("Spring Boot testing");
        task.setDescription("Update a task record in h2 database.");

        String task_ = objMapper.writeValueAsString(task);

        mockMvc.perform(patch("/api/v1/tasks/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(task_))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteTask() throws Exception {
        UUID id = UUID.fromString("cb5425f0-ed68-4336-bf6b-c2ff03c017a5");

        mockMvc.perform(delete("/api/v1/tasks/{id}", id))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}