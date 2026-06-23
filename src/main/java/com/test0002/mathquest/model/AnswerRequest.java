package com.test0002.mathquest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerRequest(
        @NotNull Long userId,
        @NotNull Long questionId,
        @NotNull Long levelId,
        @NotBlank String userAnswer
) {
}
