package icu.dreamers.xlite.listeners

import icu.dreamers.xlite.util.Chat
import icu.dreamers.xlite.xLite
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerEvent(instance: xLite): Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, instance)
    }

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
        if (p.hasPlayedBefore()) {
            e.joinMessage = Chat.color("&a&l+ &r&7${p.name}")
        } else {
            e.joinMessage = Chat.color("&7Welcome &9${p.name}&r&7, you are the ${Bukkit.getOfflinePlayers().size} guest!")
        }
    }

    @EventHandler
    fun onLeave(e: PlayerQuitEvent) {
        val p = e.player
        e.quitMessage = Chat.color("&c&l- &r&7${p.name}")
    }
}