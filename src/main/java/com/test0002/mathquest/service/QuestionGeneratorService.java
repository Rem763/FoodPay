package com.test0002.mathquest.service;

import java.util.List;
import java.util.Random;

import com.test0002.mathquest.dto.QuestionDto;
import com.test0002.mathquest.entity.QuestionEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionGeneratorService {

    private final Random random = new Random();

    public QuestionEntity generateByLevel(Long levelId) {
        int stage = levelId == null ? 1 : levelId.intValue();
        if (stage <= 1) {
            return generateAdditionOrSubtraction(levelId, 10);
        }
        if (stage == 2) {
            return generateAdditionOrSubtraction(levelId, 20);
        }
        if (stage == 3) {
            return generateAdditionOrSubtraction(levelId, 100);
        }
        if (stage == 4) {
            return generateMultiplication(levelId);
        }
        if (stage == 5) {
            return generateMixedOperation(levelId);
        }
        return generateWordProblem(levelId);
    }

    public QuestionDto toDto(QuestionEntity entity) {
        return new QuestionDto(
                entity.getId(),
                entity.getLevelId(),
                entity.getType(),
                entity.getContent(),
                entity.getAnswer(),
                entity.getAnalysis(),
                entity.getKnowledgePoint(),
                entity.getDifficulty()
        );
    }

    public List<QuestionDto> generateBatch(Long levelId, int count) {
        return java.util.stream.IntStream.range(0, count)
                .mapToObj(i -> toDto(generateByLevel(levelId)))
                .toList();
    }

    private QuestionEntity generateAdditionOrSubtraction(Long levelId, int maxRange) {
        int a = random.nextInt(maxRange) + 1;
        int b = random.nextInt(maxRange) + 1;
        boolean addition = random.nextBoolean();

        QuestionEntity question = new QuestionEntity();
        question.setLevelId(levelId);
        question.setType("fill_blank");
        question.setDifficulty(maxRange <= 10 ? "easy" : maxRange <= 20 ? "easy" : "normal");

        if (addition) {
            question.setContent(a + " + " + b + " = ?");
            question.setAnswer(String.valueOf(a + b));
            question.setAnalysis(a + " 加 " + b + " 等于 " + (a + b));
            question.setKnowledgePoint(maxRange <= 10 ? "10以内加法" : maxRange <= 20 ? "20以内加法" : "100以内加法");
        } else {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            question.setContent(max + " - " + min + " = ?");
            question.setAnswer(String.valueOf(max - min));
            question.setAnalysis(max + " 减 " + min + " 等于 " + (max - min));
            question.setKnowledgePoint(maxRange <= 10 ? "10以内减法" : maxRange <= 20 ? "20以内减法" : "100以内减法");
        }

        return question;
    }

    private QuestionEntity generateMultiplication(Long levelId) {
        int a = random.nextInt(9) + 1;
        int b = random.nextInt(9) + 1;

        QuestionEntity question = new QuestionEntity();
        question.setLevelId(levelId);
        question.setType("fill_blank");
        question.setDifficulty("normal");
        question.setContent(a + " × " + b + " = ?");
        question.setAnswer(String.valueOf(a * b));
        question.setAnalysis(a + " 乘以 " + b + " 等于 " + (a * b));
        question.setKnowledgePoint("乘法口诀");
        return question;
    }

    private QuestionEntity generateMixedOperation(Long levelId) {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(10) + 1;
        int c = random.nextInt(10) + 1;
        boolean additionFirst = random.nextBoolean();

        QuestionEntity question = new QuestionEntity();
        question.setLevelId(levelId);
        question.setType("fill_blank");
        question.setDifficulty("normal");

        if (additionFirst) {
            int result = a + b - c;
            question.setContent("(" + a + " + " + b + ") - " + c + " = ?");
            question.setAnswer(String.valueOf(result));
            question.setAnalysis("先算括号内，再减去 " + c);
        } else {
            int result = a - b + c;
            if (a < b) {
                a = b + random.nextInt(10) + 1;
                result = a - b + c;
            }
            question.setContent(a + " - " + b + " + " + c + " = ?");
            question.setAnswer(String.valueOf(result));
            question.setAnalysis("先算减法，再加上 " + c);
        }

        question.setKnowledgePoint("混合运算");
        return question;
    }

    private QuestionEntity generateWordProblem(Long levelId) {
        int apples = random.nextInt(10) + 1;
        int bought = random.nextInt(5) + 1;

        QuestionEntity question = new QuestionEntity();
        question.setLevelId(levelId);
        question.setType("fill_blank");
        question.setDifficulty("normal");
        question.setContent("小明有 " + apples + " 个苹果，又买了 " + bought + " 个，现在一共有多少个？");
        question.setAnswer(String.valueOf(apples + bought));
        question.setAnalysis("把原来有的和新买的加起来");
        question.setKnowledgePoint("简单应用题");
        return question;
    }
}
