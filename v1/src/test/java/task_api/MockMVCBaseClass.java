package task_api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MockMVCBaseClass{
    
    public MockMvc mockMvc;
 
    @BeforeEach
    public void setup(WebApplicationContext wac)  throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}