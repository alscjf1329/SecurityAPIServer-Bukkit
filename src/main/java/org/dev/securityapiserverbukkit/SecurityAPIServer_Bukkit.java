package org.dev.securityapiserverbukkit;

import org.bukkit.plugin.java.JavaPlugin;
import org.dev.securityapiserverbukkit.listener.Channel;
import org.dev.securityapiserverbukkit.listener.PluginMessageReceiver;

public final class SecurityAPIServer_Bukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getMessenger()
            .registerIncomingPluginChannel(this, Channel.BUNGEECORD_CHANNEL,
                new PluginMessageReceiver());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }
}
