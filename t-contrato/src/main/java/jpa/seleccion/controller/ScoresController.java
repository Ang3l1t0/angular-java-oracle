package jpa.seleccion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.seleccion.model.Scores;
import jpa.seleccion.repository.ScoresRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("scores")

public class ScoresController {
    @Autowired
    private ScoresRepository scoresRepository;

    @GetMapping
    public ResponseEntity<List<Scores>> getScores() {
        List<Scores> scores = scoresRepository.findAll();
        return ResponseEntity.ok(scores);
    }
}
