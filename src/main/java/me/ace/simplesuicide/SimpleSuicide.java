package me.ace.simplesuicide;

import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleSuicide extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("kill").setExecutor(new KillCommand());
    }

    @Override
    public void onDisable() {
    }
}
