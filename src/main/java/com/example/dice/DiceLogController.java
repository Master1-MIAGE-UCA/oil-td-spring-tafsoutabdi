package com.example.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceLogController {

    private final DiceRollLogRepository repository;

    // Injection de dépendances
    public DiceLogController(DiceRollLogRepository repository) {
        this.repository = repository;
    }

    // Récupérer tout l'historique des lancés
    @GetMapping("/diceLogs")
    public List<DiceRollLog> getAllLogs() {
        return repository.findAll();
    }
}

