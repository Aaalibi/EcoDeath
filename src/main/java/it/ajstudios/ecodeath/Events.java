package it.ajstudios.ecodeath;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import net.milkbowl.vault.*;

import static org.bukkit.Bukkit.getPlayer;

public class Events implements Listener {

    private String deathmessage = Main.getInstance().getConfig().getString("death-message").replace("§", "&");

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = event.getEntity().getPlayer();
        OfflinePlayer op = (OfflinePlayer) p;
        Economy economy = Main.getEconomy();

        economy.getBalance(op);
        Double money = economy.getBalance(op);
        economy.withdrawPlayer(op, money / 2);
        p.sendMessage(deathmessage);

    }

}
