package com.ursite;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Loading WhatsCraft!");
        getServer().getPluginManager().registerEvents(new PlayerConnectedListener(), this);
        getLogger().info("WhatsCraft loaded successfully!");
    }

    @Override
    public void onDisable() {
    }
}
