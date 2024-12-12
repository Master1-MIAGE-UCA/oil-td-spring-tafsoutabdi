package com.example.dice;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {
    private final Random random = new Random();

    // Méthode pour effectuer un lancé de dé
    public int roll() {
        return random.nextInt(6) + 1;  // Résultat entre 1 et 6
    }
}
