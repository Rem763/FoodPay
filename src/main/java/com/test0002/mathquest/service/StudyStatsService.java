package com.test0002.mathquest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test0002.mathquest.entity.AnswerRecordEntity;
import com.test0002.mathquest.repository.AnswerRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class StudyStatsService {

    private final AnswerRecordRepository answerRecordRepository;

    public StudyStatsService(AnswerRecordRepository answerRecordRepository) {
        this.answerRecordRepository = answerRecordRepository;
    }

    public Map<String, Object> getStats(Long userId) {
        List<AnswerRecordEntity> records = answerRecordRepository.findByUserId(userId);
        long total = records.size();
        long correct = records.stream().filter(r -> Boolean.TRUE.equals(r.getCorrect())).count();
        long wrong = total - correct;
        double accuracy = total == 0 ? 0 : (correct * 100.0 / total);
        int score = (int) (correct * 10);
        String level = accuracy >= 90 ? "三星" : accuracy >= 70 ? "二星" : total > 0 ? "一星" : "未开始";

        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("totalQuestions", total);
        result.put("correctCount", correct);
        result.put("wrongCount", wrong);
        result.put("accuracyRate", Math.round(accuracy * 100.0) / 100.0);
        result.put("score", score);
        result.put("starLevel", level);
        return result;
    }
}
