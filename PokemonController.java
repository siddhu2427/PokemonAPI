package com.impact.pokemon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class PokemonController {

    @Resource
    private PokemonData data;

    @GetMapping("/attack")
    public ResponseEntity<?> attack(@RequestParam String pokemonA, @RequestParam String pokemonB) {
        try {
            Pokemon p1 = data.findByName(pokemonA);
            Pokemon p2 = data.findByName(pokemonB);

            // Simulate the battle logic here
            String winner = "Charmeleon"; // Replace this with actual logic
            int remainingHp = 50; // Replace this with actual calculation

            return ResponseEntity.ok(Map.of("winner", winner, "remainingHp", remainingHp));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
