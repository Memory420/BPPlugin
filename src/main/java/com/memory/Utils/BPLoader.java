package com.memory.Utils;

import com.memory.BattlePass;
import com.memory.Level;
import com.memory.Reward;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class BPLoader {
    public static BattlePass loadFromFile(){
        InputStream inputStream = BPLoader.class.getClassLoader().getResourceAsStream("rewards.yml");
        if (inputStream == null){
            throw new RuntimeException("Файл rewards.yml не найден в папке resources");
        }
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        return loadBattlePass(data);
    }
    private static BattlePass loadBattlePass(Map<String, Object> data) {
        Map<String, Object> battlePassData = (Map<String, Object>) data.get("battlepass");
        Map<Integer, Map<String, Object>> levelsData = (Map<Integer, Map<String, Object>>) battlePassData.get("levels");

        Map<Integer, Level> levels = new HashMap<>();

        for (Integer levelNumber : levelsData.keySet()) {
            Map<String, Object> levelInfo = levelsData.get(levelNumber);

            int experienceRequired = (Integer) levelInfo.get("experience_required");

            Map<String, Object> rewardData = (Map<String, Object>) levelInfo.get("reward");
            String type = (String) rewardData.get("type");
            String name = (String) rewardData.get("name");
            int amount = (Integer) rewardData.get("amount");

            Reward reward = new Reward(type, name, amount);

            levels.put(levelNumber, new Level(experienceRequired, reward));
        }
        return new BattlePass(levels);
    }


}
