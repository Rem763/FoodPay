package com.test0002.mathquest.model;

public record AnswerResult(
        boolean correct,
        int score,
        String message
) {
}
