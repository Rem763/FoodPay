INSERT INTO `level` (id, title, chapter, difficulty, question_count, pass_score, unlocked) VALUES
(1, '10以内加减法', '基础运算', 'easy', 5, 60, true),
(2, '20以内加减法', '基础运算', 'easy', 5, 70, false),
(3, '100以内加减法', '基础运算', 'normal', 8, 80, false)
ON DUPLICATE KEY UPDATE
  title = VALUES(title),
  chapter = VALUES(chapter),
  difficulty = VALUES(difficulty),
  question_count = VALUES(question_count),
  pass_score = VALUES(pass_score),
  unlocked = VALUES(unlocked);

INSERT INTO question (id, level_id, type, content, answer, analysis, knowledge_point, difficulty) VALUES
(1, 1, 'single_choice', '3 + 2 = ?', '5', '3和2相加等于5', '10以内加法', 'easy'),
(2, 1, 'fill_blank', '7 - 4 = ?', '3', '7减4等于3', '10以内减法', 'easy'),
(3, 2, 'fill_blank', '9 + 6 = ?', '15', '9加6等于15', '20以内加法', 'easy')
ON DUPLICATE KEY UPDATE
  level_id = VALUES(level_id),
  type = VALUES(type),
  content = VALUES(content),
  answer = VALUES(answer),
  analysis = VALUES(analysis),
  knowledge_point = VALUES(knowledge_point),
  difficulty = VALUES(difficulty);
