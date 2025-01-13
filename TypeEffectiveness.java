package com.impact.pokemon;

public class TypeEffectiveness {

    public static double getEffectiveness(String attackerType, String defenderType) {
        switch (attackerType) {
            case "Fire":
                return defenderType.equals("Grass") ? 2.0 : defenderType.equals("Water") ? 0.5 : 1.0;
            case "Water":
                return defenderType.equals("Fire") ? 2.0 : defenderType.equals("Electric") ? 0.5 : 1.0;
            case "Grass":
                return defenderType.equals("Electric") ? 2.0 : defenderType.equals("Fire") ? 0.5 : 1.0;
            case "Electric":
                return defenderType.equals("Water") ? 2.0 : defenderType.equals("Grass") ? 0.5 : 1.0;
            default:
                return 1.0;
        }
    }
}
