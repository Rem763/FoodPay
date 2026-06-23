package com.test0002.mathquest.service;

import java.util.List;
import java.util.stream.Collectors;

import com.test0002.mathquest.entity.LevelEntity;
import com.test0002.mathquest.model.Level;
import com.test0002.mathquest.repository.LevelRepository;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> getLevels() {
        return levelRepository.findAll().stream()
                .map(entity -> new Level(
                        entity.getId(),
                        entity.getTitle(),
                        entity.getChapter(),
                        entity.getDifficulty(),
                        entity.getQuestionCount(),
                        entity.getPassScore(),
                        Boolean.TRUE.equals(entity.getUnlocked())
                ))
                .collect(Collectors.toList());
    }
}
