package com.altar.legends;

import org.bukkit.plugin.java.JavaPlugin;
import com.altar.legends.listeners.AbilityListener;
import com.altar.legends.commands.GiveLegendCommand;

public class AltarLegends extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AbilityListener(), this);
        getCommand("givelegend").setExecutor(new GiveLegendCommand());
        getLogger().info("Altar Legends Enabled!");
    }
}