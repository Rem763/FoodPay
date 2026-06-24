# 数字闯关 — 小学生数学闯关游戏

基于 JavaFX 的丛林探险主题数学闯关游戏，覆盖小学 1~3 年级算术知识点，回合制答题战斗 + 地图选关。

## 玩法概要

- **地图选关** — 丛林世界地图，三个年级区域逐步解锁
- **回合战斗** — 遇怪答题，4选1选择题，答对攻击、答错扣血
- **技能系统** — 连对攒技能点，释放暴击/回血/必对
- **道具商店** — 金币购买药水、卷轴、护盾等战斗道具
- **星级评定** — 根据剩余血量评 1~3 星，3星解锁下一关

## 功能范围

### 已纳入首版
- 主菜单：新游戏、继续游戏、设置占位
- 地图选关：年级切换、关卡解锁、重复挑战、商店入口
- 战斗系统：答题、技能、道具、逃跑、战斗结束结算
- 商店系统：道具购买、背包管理
- 存档系统：自动存档、继续游戏加载

### 后续版本
- 音效和背景音乐
- 角色换装/形象定制
- 排行榜
- 成就徽章系统
- 关卡编辑器

## 技术栈

- Java 17+
- JavaFX — 桌面 GUI（Scene + FXML + CSS）
- Maven — 构建管理
- MySQL — 玩家数据存储
- HikariCP — 数据库连接池

## 环境要求

- JDK 17+
- MySQL 8.0+
- Maven 3.8+

启动前先创建数据库：

```sql
CREATE DATABASE number_quest;
```

然后修改 `src/main/resources/db.properties` 中的数据库连接信息。

## 快速开始

```bash
mvn javafx:run
```

## 项目结构

```
src/main/java/com/quest/
├── App.java                 # 入口
├── SceneManager.java        # Scene 切换管理
├── data/
│   ├── model/              # Player, Enemy, Level, Item, Question
│   ├── dao/                # PlayerDao, ItemDao, StarDao
│   └── DatabaseManager.java  # HikariCP 连接池管理
├── scene/
│   ├── TitleScene.java     # 主菜单
│   ├── MapScene.java       # 地图选关
│   ├── BattleScene.java    # 回合战斗
│   ├── ShopScene.java      # 道具商店
│   └── ResultScene.java    # 战斗结算
├── logic/
│   ├── BattleEngine.java   # 战斗回合逻辑
│   ├── QuestionGenerator.java  # 随机出题
│   ├── StarCalculator.java # 星级评定
│   └── ShopService.java    # 购买/背包
└── config/
    ├── LevelData.java      # 关卡配置
    ├── EnemyData.java      # 怪物配置
    └── ItemData.java       # 道具配置
```

## 数据库表

| 表 | 说明 |
|---|------|
| `player` | 玩家状态（单行，HP/攻击/金币/进度） |
| `player_items` | 玩家道具背包 |
| `player_stars` | 关卡星级记录 |

## 题目难度分级

| 怪物难度 | 对应年级 | 范围 |
|---------|---------|------|
| 1 | 一年级上 | 10以内加减 |
| 2 | 一年级下 | 20以内加减 |
| 3 | 二年级上 | 100以内加减 |
| 4 | 二年级下 | 乘法口诀 |
| 5 | 三年级 | 混合运算 |

## 道具列表

| 道具 | 效果 | 价格 |
|------|------|------|
| 回复药水 | 恢复 30% HP | 50 |
| 大回复药水 | 恢复 60% HP | 100 |
| 攻击卷轴 | 本场攻击 +5 | 80 |
| 护盾石 | 抵消一次伤害 | 120 |
| 提示羽毛 | 排除 2 个错误选项 | 30 |

## 设计文档

详见 [docs/设计文档.md](docs/设计文档.md)
