package com.test0002.mathquest.controller;

import java.util.List;

import com.test0002.mathquest.model.Level;
import com.test0002.mathquest.service.LevelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/api/levels")
    public List<Level> levels() {
        return levelService.getLevels();
    }
}
