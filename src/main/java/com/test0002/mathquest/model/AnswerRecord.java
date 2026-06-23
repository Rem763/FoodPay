package com.test0002.mathquest.model;

import java.time.LocalDateTime;

public record AnswerRecord(
        Long id,
        Long userId,
        Long questionId,
        Long levelId,
        String userAnswer,
        boolean correct,
        Long answerTimeMs,
        LocalDateTime createdAt
) {
}
