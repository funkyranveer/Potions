package me.funky.fastpot;

import me.funky.fastpot.commands.FastpotCommand;
import me.funky.fastpot.listeners.PotionListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.funky.fastpot.utils.CC;
public class FastPot extends JavaPlugin {
    private static FastPot instance;

    public static FastPot get() {
        return instance;
    }

    // Added Values  - funkyranveer
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(CC.chat("&aEnabled Potions"));
        instance = this;
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("fastpot", Double.valueOf(1.0D));
        getConfig().addDefault("permission", "fastpot.command");
        saveConfig();
        reloadConfig();
        registerListeners();
        registerCommands();
    }

    public void onDisable() {
        instance = null;
    }

    private void registerCommands() {
        getCommand("fastpot").setExecutor((CommandExecutor)new FastpotCommand());
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents((Listener)new PotionListener(), (Plugin)this);
    }

    public void setFastpotTo(Double values) {
        getConfig().set("fastpot", values);
        saveConfig();
        reloadConfig();
    }

    public Double getFastpotValue() {
        return Double.valueOf(getConfig().getDouble("fastpot"));
    }
}