package io.github.com.haxzk.auto.broadcast

import io.github.com.haxzk.auto.broadcast.libraries.Snippets
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class HAutoBroadcast : JavaPlugin() {

    override fun onEnable() {
        saveDefaultConfig()
        Bukkit.getScheduler().runTaskTimer(this, {
            run {
                val i = Random().nextInt(getMessage())
                if (config.getInt("$i.Tipo") == 1) {
                    Bukkit.broadcastMessage(config.getString("$i.Mensagem").replace('&', '§'))
                } else {
                    for (p in Bukkit.getOnlinePlayers()) {
                        Snippets().sendActionBar(p, config.getString("$i.Mensagem").replace('&', '§'))
                    }
                }
            }
        }, 20L, 20L * config.getInt("Tempo"))
    }

    fun getMessage() : Int {
        return config.getConfigurationSection("Mensagens").getKeys(false).size
    }


}