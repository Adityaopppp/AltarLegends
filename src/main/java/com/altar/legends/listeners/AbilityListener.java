package com.altar.legends.listeners;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.Particle;
import org.bukkit.Sound;
import com.altar.legends.systems.CooldownManager;

public class AbilityListener implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) return;

        String name = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        String key = p.getName()+"_"+name;

        if (CooldownManager.onCooldown(key, 5)) {
            p.sendActionBar("Cooldown: "+CooldownManager.get(key,5));
            return;
        }

        // Example animation
        p.getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 50);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1,1);

        CooldownManager.set(key);
    }
}