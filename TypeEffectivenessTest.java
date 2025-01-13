package com.impact.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeEffectivenessTest {

    @Test
    void testFireEffectiveness() {
        assertEquals(2.0, TypeEffectiveness.getEffectiveness("Fire", "Grass"));
        assertEquals(0.5, TypeEffectiveness.getEffectiveness("Fire", "Water"));
        assertEquals(1.0, TypeEffectiveness.getEffectiveness("Fire", "Electric"));
    }

    @Test
    void testWaterEffectiveness() {
        assertEquals(2.0, TypeEffectiveness.getEffectiveness("Water", "Fire"));
        assertEquals(0.5, TypeEffectiveness.getEffectiveness("Water", "Electric"));
        assertEquals(1.0, TypeEffectiveness.getEffectiveness("Water", "Grass"));
    }

    @Test
    void testGrassEffectiveness() {
        assertEquals(2.0, TypeEffectiveness.getEffectiveness("Grass", "Electric"));
        assertEquals(0.5, TypeEffectiveness.getEffectiveness("Grass", "Fire"));
        assertEquals(1.0, TypeEffectiveness.getEffectiveness("Grass", "Water"));
    }

    @Test
    void testElectricEffectiveness() {
        assertEquals(2.0, TypeEffectiveness.getEffectiveness("Electric", "Water"));
        assertEquals(0.5, TypeEffectiveness.getEffectiveness("Electric", "Grass"));
        assertEquals(1.0, TypeEffectiveness.getEffectiveness("Electric", "Fire"));
    }
}
