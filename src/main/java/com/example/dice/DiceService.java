package com.example.dice;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository repository;

    // Injection de dépendances
    public DiceService(Dice dice, DiceRollLogRepository repository) {
        this.dice = dice;
        this.repository = repository;
    }

    // Méthode principale pour gérer les lancés de dés
    public List<Integer> rollDices(int count) {
        List<Integer> results = IntStream.range(0, count)
                .map(i -> dice.roll())
                .boxed()
                .collect(Collectors.toList());

        // Enregistrement dans la base de données
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(results.toString());
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);

        return results;
    }
}
