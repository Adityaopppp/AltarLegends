package com.altar.legends.systems;

import java.util.HashMap;

public class CooldownManager {
    private static final HashMap<String, Long> map = new HashMap<>();

    public static boolean onCooldown(String key, int sec) {
        if (!map.containsKey(key)) return false;
        return System.currentTimeMillis() - map.get(key) < sec * 1000;
    }

    public static int get(String key, int sec) {
        long left = sec - ((System.currentTimeMillis() - map.getOrDefault(key,0L)) / 1000);
        return (int)Math.max(0, left);
    }

    public static void set(String key) {
        map.put(key, System.currentTimeMillis());
    }
}