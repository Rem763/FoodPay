package com.test0002.mathquest.controller;

import java.util.List;

import com.test0002.mathquest.entity.AnswerRecordEntity;
import com.test0002.mathquest.service.WrongQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WrongQuestionController {

    private final WrongQuestionService wrongQuestionService;

    public WrongQuestionController(WrongQuestionService wrongQuestionService) {
        this.wrongQuestionService = wrongQuestionService;
    }

    @GetMapping("/api/wrong-questions")
    public List<AnswerRecordEntity> wrongQuestions(@RequestParam Long userId) {
        return wrongQuestionService.getWrongQuestions(userId);
    }
}
