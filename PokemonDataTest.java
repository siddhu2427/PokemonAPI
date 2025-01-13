package com.impact.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonDataTest {
    @Test
    void testFindByName() {
        PokemonData data = new PokemonData();

        Pokemon pokemon = data.findByName("Charizard");
        assertNotNull(pokemon);
        assertEquals("Charizard", pokemon.getName());
        assertEquals("Fire", pokemon.getType());
    }

    @Test
    void testFindByNameNotFound() {
        PokemonData data = new PokemonData();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            data.findByName("Unknown");
        });

        assertEquals("Pokemon not found: Unknown", exception.getMessage());
    }
}
