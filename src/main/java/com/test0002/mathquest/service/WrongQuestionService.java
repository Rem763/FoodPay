package com.test0002.mathquest.service;

import java.util.List;

import com.test0002.mathquest.entity.AnswerRecordEntity;
import com.test0002.mathquest.repository.AnswerRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class WrongQuestionService {

    private final AnswerRecordRepository answerRecordRepository;

    public WrongQuestionService(AnswerRecordRepository answerRecordRepository) {
        this.answerRecordRepository = answerRecordRepository;
    }

    public List<AnswerRecordEntity> getWrongQuestions(Long userId) {
        return answerRecordRepository.findByUserIdAndCorrectFalse(userId);
    }
}
