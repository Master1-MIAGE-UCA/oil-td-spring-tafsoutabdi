package com.example.dice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class DiceController {
    private final Dice dice;
    private final DiceRollLogRepository repository;

    // Injection de dépendances
    public DiceController(Dice dice, DiceRollLogRepository repository) {
        this.dice = dice;
        this.repository = repository;
    }

    // Lancer un seul dé
    @GetMapping("/rollDice")
    public int rollSingleDice() {
        return dice.roll();
    }

    // Lancer plusieurs dés
    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        List<Integer> results = IntStream.range(0, count)
                .map(i -> dice.roll())
                .boxed()
                .collect(Collectors.toList());

        // Sauvegarde dans la base de données
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(results.toString());
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);

        return results;
    }
}
