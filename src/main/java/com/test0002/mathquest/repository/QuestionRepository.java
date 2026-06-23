package com.test0002.mathquest.repository;

import java.util.List;

import com.test0002.mathquest.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    List<QuestionEntity> findByLevelId(Long levelId);
}
