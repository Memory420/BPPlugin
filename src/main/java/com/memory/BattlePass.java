package com.memory;

import java.util.Map;

public class BattlePass {
    private Map<Integer, Level> levels;

    public BattlePass(Map<Integer, Level> levels) {
        this.levels = levels;
    }

    public Map<Integer, Level> getLevels() {
        return levels;
    }

    public Level getLevel(int level) {
        return levels.get(level);
    }
}
