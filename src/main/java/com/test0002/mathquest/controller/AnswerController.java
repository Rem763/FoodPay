package com.test0002.mathquest.controller;

import com.test0002.mathquest.model.AnswerRequest;
import com.test0002.mathquest.model.AnswerResult;
import com.test0002.mathquest.service.AnswerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/api/answers")
    public AnswerResult submit(@Valid @RequestBody AnswerRequest request) {
        return answerService.submit(request);
    }
}
