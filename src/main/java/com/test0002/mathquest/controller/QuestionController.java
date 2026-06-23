package com.test0002.mathquest.controller;

import java.util.List;

import com.test0002.mathquest.dto.QuestionDto;
import com.test0002.mathquest.model.Question;
import com.test0002.mathquest.service.QuestionGeneratorService;
import com.test0002.mathquest.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionGeneratorService questionGeneratorService;

    public QuestionController(QuestionService questionService, QuestionGeneratorService questionGeneratorService) {
        this.questionService = questionService;
        this.questionGeneratorService = questionGeneratorService;
    }

    @GetMapping("/api/questions")
    public List<Question> questions(@RequestParam(required = false, defaultValue = "1") Long levelId) {
        return questionService.getQuestions(levelId);
    }

    @GetMapping("/api/questions/generated")
    public List<QuestionDto> generatedQuestions(
            @RequestParam(required = false, defaultValue = "1") Long levelId,
            @RequestParam(required = false, defaultValue = "5") int count) {
        return questionGeneratorService.generateBatch(levelId, count);
    }

    @GetMapping("/api/questions/{questionId}")
    public QuestionDto questionDetail(@PathVariable Long questionId) {
        return questionService.getQuestionDetail(questionId);
    }
}
