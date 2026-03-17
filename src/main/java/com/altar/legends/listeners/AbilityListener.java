package com.altar.legends.listeners;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.kyori.adventure.text.Component;

import com.altar.legends.systems.CooldownManager;

public class AbilityListener implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        ItemStack item = p.getInventory().getItemInMainHand();
        if (item == null || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        if (meta == null || !meta.hasDisplayName()) return;

        String name = meta.getDisplayName();
        String key = p.getName() + "_" + name;

        // Cooldown check
        if (CooldownManager.onCooldown(key, 5)) {
            int remaining = CooldownManager.get(key, 5);
            p.sendActionBar(Component.text("Cooldown: " + remaining + "s"));
            return;
        }

        // 🔥 Ability Animation (basic for now)
        p.getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 50, 0.5, 0.5, 0.5, 0.01);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);

        // Set cooldown
        CooldownManager.set(key);
    }
}
