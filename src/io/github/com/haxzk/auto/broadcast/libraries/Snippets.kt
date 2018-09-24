package io.github.com.haxzk.auto.broadcast.libraries

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player

class Snippets {

    /*
    public static void sendActionBar(Player p, String msg) {
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msg + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(cbc, (byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }
     */

    fun sendActionBar(player: Player, string: String) : Unit {
        val chatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"$string\"}")
        val packetPlayOutChat = PacketPlayOutChat(chatBaseComponent, 2)
        val craftPlayer = player as CraftPlayer
        craftPlayer.handle.playerConnection.sendPacket(packetPlayOutChat)
    }

}