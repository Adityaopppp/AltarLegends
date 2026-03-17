package com.altar.legends;

import org.bukkit.plugin.java.JavaPlugin;
import com.altar.legends.listeners.AbilityListener;

public class AltarLegends extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AbilityListener(), this);
        getLogger().info("Altar Legends Enabled!");
    }
}