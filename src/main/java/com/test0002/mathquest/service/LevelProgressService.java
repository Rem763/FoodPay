package com.test0002.mathquest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test0002.mathquest.entity.AnswerRecordEntity;
import com.test0002.mathquest.entity.LevelEntity;
import com.test0002.mathquest.repository.AnswerRecordRepository;
import com.test0002.mathquest.repository.LevelRepository;
import org.springframework.stereotype.Service;

@Service
public class LevelProgressService {

    private final LevelRepository levelRepository;
    private final AnswerRecordRepository answerRecordRepository;

    public LevelProgressService(LevelRepository levelRepository, AnswerRecordRepository answerRecordRepository) {
        this.levelRepository = levelRepository;
        this.answerRecordRepository = answerRecordRepository;
    }

    public Map<String, Object> getProgress(Long userId) {
        List<LevelEntity> levels = levelRepository.findAll();
        List<AnswerRecordEntity> records = answerRecordRepository.findByUserId(userId);
        long completedCount = records.stream().filter(r -> Boolean.TRUE.equals(r.getCorrect())).count() > 0 ? 1 : 0;

        Map<String, Object> result = new HashMap<>();
        result.put("totalLevels", levels.size());
        result.put("completedLevels", completedCount);
        result.put("nextRecommendedLevelId", levels.isEmpty() ? null : levels.get(0).getId());
        result.put("levels", levels.stream().map(level -> Map.of(
                "id", level.getId(),
                "title", level.getTitle(),
                "unlocked", Boolean.TRUE.equals(level.getUnlocked())
        )).toList());
        return result;
    }
}
