package com.test0002.mathquest.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.test0002.mathquest.entity.AnswerRecordEntity;
import com.test0002.mathquest.entity.QuestionEntity;
import com.test0002.mathquest.model.AnswerRequest;
import com.test0002.mathquest.model.AnswerResult;
import com.test0002.mathquest.repository.AnswerRecordRepository;
import com.test0002.mathquest.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRecordRepository answerRecordRepository;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRecordRepository answerRecordRepository, QuestionRepository questionRepository) {
        this.answerRecordRepository = answerRecordRepository;
        this.questionRepository = questionRepository;
    }

    public AnswerResult submit(AnswerRequest request) {
        Optional<QuestionEntity> questionOptional = questionRepository.findById(request.questionId());
        if (questionOptional.isEmpty()) {
            return new AnswerResult(false, 0, "题目不存在，请刷新后重试。");
        }

        QuestionEntity question = questionOptional.get();
        boolean correct = question.getAnswer() != null && question.getAnswer().trim().equals(request.userAnswer().trim());
        int score = correct ? 10 : 0;

        AnswerRecordEntity record = new AnswerRecordEntity();
        record.setUserId(request.userId());
        record.setQuestionId(request.questionId());
        record.setLevelId(request.levelId());
        record.setUserAnswer(request.userAnswer());
        record.setCorrect(correct);
        record.setAnswerTimeMs(0L);
        record.setCreatedAt(LocalDateTime.now());
        answerRecordRepository.save(record);

        return new AnswerResult(correct, score, correct ? "回答正确，继续加油！" : "答案不对，再试一次吧！");
    }
}
