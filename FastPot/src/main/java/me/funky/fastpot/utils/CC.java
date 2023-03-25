package me.funky.fastpot.utils;

import org.bukkit.ChatColor;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

public class CC {
    public static String chat(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> list(List<String> s) {
        List<String> strings = new ArrayList<>();
        s.forEach(str -> strings.add(ChatColor.translateAlternateColorCodes('&', str)));
        return strings;
    }

    public static List<String> colorLines(List<String> lore) {
        List<String> color = new ArrayList<>();
        for (String s : lore)
            color.add(chat(s));
        return color;
    }
}
