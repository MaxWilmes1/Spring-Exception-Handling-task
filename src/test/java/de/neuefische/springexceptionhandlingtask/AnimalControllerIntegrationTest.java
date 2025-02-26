package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void expectOnlyDogAllowedException_WhenCatIsUsedAsSpecies() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/animals/cat")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Only 'dog' is allowed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.exceptionType").value("OnlyDogAllowedException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());
    }

    @Test
    void expectOnlyPorscheAllowedException_WhenAudiIsUsedAsBrand() throws Exception {
            mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/cars/audi")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Only 'porsche' allowed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.exceptionType").value("OnlyPorscheAllowedException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());
    }

    @Test
    void expectNoSuchElementException_WhenGetAllCars() throws Exception {
            mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/cars")
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No Cars found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.exceptionType").value("NoSuchElementException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());
    }

    @Test
    void expectNoSuchElementException_WhenGetAllAnimals() throws Exception {
            mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/animals")
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No Animals found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.exceptionType").value("NoSuchElementException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());
    }
}
