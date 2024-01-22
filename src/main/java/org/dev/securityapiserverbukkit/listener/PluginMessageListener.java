package org.dev.securityapiserverbukkit.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.dev.securityapiserverbukkit.service.CopyService;
import org.dev.securityapiserverbukkit.views.OutViews;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals(Channel.BUNGEECORD_CHANNEL)) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String forwardType = in.readUTF();
        if (!forwardType.equals(ForwardType.FORWARD_TO_PLAYER.getName())) {
            return;
        }

        String nickname = in.readUTF();
        if (!nickname.equals(player.getName())) {
            return;
        }

        String subChannel = in.readUTF();
        if (!subChannel.equals(Channel.SECURITY_SUBCHANNEL.getName())) {
            return;
        }
        String token = in.readUTF();
        String expiration = in.readUTF();

        CopyService.copyToClipboard(token);
        String incomingMessage = OutViews.TOKEN_FORMAT.toString(token, expiration);
        player.sendMessage(incomingMessage);
    }
}