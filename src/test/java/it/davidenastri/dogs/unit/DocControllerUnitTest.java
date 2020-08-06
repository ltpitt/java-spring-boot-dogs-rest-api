package it.davidenastri.dogs.unit;


import it.davidenastri.dogs.controller.DogController;
import it.davidenastri.dogs.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DocControllerUnitTest {

    @MockBean
    DogService dogService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin")
    public void getAllDogs() throws Exception {

        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

    }

}
