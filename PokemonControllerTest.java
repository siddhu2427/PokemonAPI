package com.impact.pokemon;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonData pokemonData;

    @Test
    public void testInvalidPokemonName() throws Exception {
        when(pokemonData.findByName("InvalidName"))
                .thenThrow(new IllegalArgumentException("Pokemon not found: InvalidName"));

        mockMvc.perform(get("/attack")
                        .param("pokemonA", "InvalidName")
                        .param("pokemonB", "Illumise"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Pokemon not found: InvalidName"));
    }

    @Test
    public void testValidPokemonNames() throws Exception {
        when(pokemonData.findByName("Illumise"))
                .thenReturn(new Pokemon("Illumise", "Bug", 65, 47, 75, 85));
        when(pokemonData.findByName("Charmeleon"))
                .thenReturn(new Pokemon("Charmeleon", "Fire", 58, 64, 58, 80));

        mockMvc.perform(get("/attack")
                        .param("pokemonA", "Illumise")
                        .param("pokemonB", "Charmeleon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.winner").value("Charmeleon"))
                .andExpect(jsonPath("$.remainingHp").value(50));
    }
}
