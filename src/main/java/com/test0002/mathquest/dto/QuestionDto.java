package com.test0002.mathquest.dto;

public record QuestionDto(
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
