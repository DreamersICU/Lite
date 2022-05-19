package icu.dreamers.xlite.listeners

import icu.dreamers.xlite.xLite
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatListener(instance: xLite): Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, instance)
    }

    @EventHandler
    fun onChat(e: AsyncPlayerChatEvent) {
        val p = e.player
        e.message = (ChatColor.translateAlternateColorCodes('&', "&7${p.name} &r&8» &r${e.message}"))
    }
}