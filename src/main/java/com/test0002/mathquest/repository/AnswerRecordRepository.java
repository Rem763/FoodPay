package com.test0002.mathquest.repository;

import java.util.List;

import com.test0002.mathquest.entity.AnswerRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRecordRepository extends JpaRepository<AnswerRecordEntity, Long> {

    List<AnswerRecordEntity> findByUserIdAndCorrectFalse(Long userId);

    List<AnswerRecordEntity> findByUserId(Long userId);
}
