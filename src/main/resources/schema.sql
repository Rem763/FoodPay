CREATE DATABASE IF NOT EXISTS math_quest DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE math_quest;

CREATE TABLE IF NOT EXISTS `level` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `chapter` VARCHAR(100) NOT NULL,
  `difficulty` VARCHAR(50) NOT NULL,
  `question_count` INT NOT NULL,
  `pass_score` INT NOT NULL,
  `unlocked` BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS question (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `level_id` BIGINT NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `answer` VARCHAR(100) NOT NULL,
  `analysis` VARCHAR(255),
  `knowledge_point` VARCHAR(100),
  `difficulty` VARCHAR(50) NOT NULL,
  INDEX idx_question_level_id (`level_id`)
);

CREATE TABLE IF NOT EXISTS answer_record (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `question_id` BIGINT NOT NULL,
  `level_id` BIGINT NOT NULL,
  `user_answer` VARCHAR(100) NOT NULL,
  `correct` BOOLEAN NOT NULL,
  `answer_time_ms` BIGINT,
  `created_at` DATETIME NOT NULL,
  INDEX idx_answer_user_id (`user_id`),
  INDEX idx_answer_level_id (`level_id`),
  INDEX idx_answer_question_id (`question_id`)
);
