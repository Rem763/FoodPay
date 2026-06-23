package com.test0002.mathquest.controller;

import java.util.Map;

import com.test0002.mathquest.service.LevelProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelProgressController {

    private final LevelProgressService levelProgressService;

    public LevelProgressController(LevelProgressService levelProgressService) {
        this.levelProgressService = levelProgressService;
    }

    @GetMapping("/api/level-progress")
    public Map<String, Object> progress(@RequestParam Long userId) {
        return levelProgressService.getProgress(userId);
    }
}
