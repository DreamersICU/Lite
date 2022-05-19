package icu.dreamers.xlite

import icu.dreamers.xlite.commands.GamemodeCommand
import icu.dreamers.xlite.listeners.ChatListener
import icu.dreamers.xlite.listeners.PlayerEvent
import org.bukkit.plugin.java.JavaPlugin

class xLite : JavaPlugin() {

    init {
        instance = this
    }

    override fun onEnable() {
        /* TODO:
            - Chat Listener | Done
            - Join/Leave Listener | Done
            - Commands
            - Warps
            - Point Locator
        */

        GamemodeCommand(getCommand("gamemode")!!)

        /* Listeners */

        ChatListener(instance)
        PlayerEvent(instance)
    }

    companion object {
        lateinit var instance: xLite
            private set
    }
}