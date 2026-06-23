package com.test0002.mathquest.model;

public record Question(
        Long id,
        Long levelId,
        String type,
        String content,
        String answer,
        String analysis,
        String knowledgePoint,
        String difficulty
) {
}
