package task_api;

import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.web.WebAppConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public abstract class MockMVCBaseClass{
    
    public MockMvc mockMvc;
    public final ObjectMapper objMapper = new ObjectMapper();
  
    @BeforeEach 
    public void setup(WebApplicationContext wac)  throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}