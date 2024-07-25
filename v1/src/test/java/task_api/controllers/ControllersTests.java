package task_api.controllers;

import task_api.MockMVCBaseClass;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class ControllerTest extends MockMVCBaseClass{

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/api/v1/tasks"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}