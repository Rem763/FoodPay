package com.test0002.mathquest.service;

import java.util.List;
import java.util.stream.Collectors;

import com.test0002.mathquest.dto.QuestionDto;
import com.test0002.mathquest.entity.QuestionEntity;
import com.test0002.mathquest.model.Question;
import com.test0002.mathquest.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionGeneratorService questionGeneratorService;

    public QuestionService(QuestionRepository questionRepository, QuestionGeneratorService questionGeneratorService) {
        this.questionRepository = questionRepository;
        this.questionGeneratorService = questionGeneratorService;
    }

    public List<Question> getQuestions(Long levelId) {
        return questionRepository.findByLevelId(levelId).stream()
                .map(entity -> new Question(
                        entity.getId(),
                        entity.getLevelId(),
                        entity.getType(),
                        entity.getContent(),
                        entity.getAnswer(),
                        entity.getAnalysis(),
                        entity.getKnowledgePoint(),
                        entity.getDifficulty()
                ))
                .collect(Collectors.toList());
    }

    public QuestionDto getQuestionDetail(Long questionId) {
        QuestionEntity entity = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("题目不存在"));
        return questionGeneratorService.toDto(entity);
    }
}
