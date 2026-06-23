package com.test0002.mathquest.controller;

import java.util.Map;

import com.test0002.mathquest.service.StudyStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyStatsController {

    private final StudyStatsService studyStatsService;

    public StudyStatsController(StudyStatsService studyStatsService) {
        this.studyStatsService = studyStatsService;
    }

    @GetMapping("/api/study-stats")
    public Map<String, Object> stats(@RequestParam Long userId) {
        return studyStatsService.getStats(userId);
    }
}
