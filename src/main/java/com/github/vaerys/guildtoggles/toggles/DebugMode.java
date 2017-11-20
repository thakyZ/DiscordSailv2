package com.github.vaerys.guildtoggles.toggles;

import com.github.vaerys.commands.CommandObject;
import com.github.vaerys.pogos.GuildConfig;
import com.github.vaerys.templates.GuildSetting;

public class DebugMode extends GuildSetting {
    @Override
    public String name() {
        return "DebugMode";
    }

    @Override
    public boolean toggle(GuildConfig config) {
        return config.debugMode = !config.debugMode;
    }

    @Override
    public boolean get(GuildConfig config) {
        return config.debugMode;
    }

    @Override
    public boolean getDefault() {
        return new GuildConfig().debugMode;
    }

    @Override
    public String desc(CommandObject command) {
        return "Enables the bypasses for the bot developer.";
    }

    @Override
    public void setup() {

    }
}