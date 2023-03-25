package me.funky.fastpot.commands;

import me.funky.fastpot.FastPot;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FastpotCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission(FastPot.get().getConfig().get("permission").toString())) {
            if (args.length == 0) {
                sender.sendMessage("usage: /fastpot <get/set/reload> <values>");
            } else if (args.length >= 1) {
                if (args[0].equals("get")) {
                    sender.sendMessage("values: " + FastPot.get().getFastpotValue());
                } else if (args[0].equals("set")) {
                    if (args.length >= 2) {
                        Double arg = Double.valueOf(NumberUtils.toDouble(args[1], -1.0D));
                        if (arg.doubleValue() < 0.0D) {
                            sender.sendMessage("Fastpot value.");
                            return true;
                        }
                        sender.sendMessage("of " + Bukkit.getServer() + " set to " + arg + ".");
                        FastPot.get().setFastpotTo(arg);
                    } else {
                        sender.sendMessage("usage: /fastpot <set> <values>");
                    }
                } else if (args[0].equals("reload")) {
                    FastPot.get().reloadConfig();
                    sender.sendMessage("configuration has been reloaded.");
                } else {
                    sender.sendMessage("usage: /fastpot <get/set/reload> <values>");
                }
            } else {
                sender.sendMessage("usage: /fastpot <get/set/reload> <values>");
            }
        } else {
            sender.sendMessage("permission.");
        }
        return false;
    }
}
