package com.impact.pokemon;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonData {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pokemon_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "$iDD8u@2285";
    private List<Pokemon> pokemonList = new ArrayList<>();

    public PokemonData() {
        loadPokemonDataFromDatabase();
    }

    private void loadPokemonDataFromDatabase() {
        String sql = "SELECT * FROM pokemon";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int hitPoints = resultSet.getInt("hitPoints");
                int attack = resultSet.getInt("attack");
                int defense = resultSet.getInt("defense");
                int speed = resultSet.getInt("speed");

                pokemonList.add(new Pokemon(name, type, hitPoints, attack, defense, speed));
            }

            System.out.println("Loaded Pokémon data from MySQL.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pokemon findByName(String name) {
        return pokemonList.stream()
                .filter(pokemon -> pokemon.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pokemon not found: " + name));
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonList;
    }
}
