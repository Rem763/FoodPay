package com.test0002.mathquest.model;

public record Level(
        Long id,
        String title,
        String chapter,
        String difficulty,
        Integer questionCount,
        Integer passScore,
        boolean unlocked
) {
}
