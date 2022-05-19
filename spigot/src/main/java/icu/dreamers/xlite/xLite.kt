package icu.dreamers.xlite

import icu.dreamers.xlite.listeners.ChatListener
import org.bukkit.plugin.java.JavaPlugin

class xLite : JavaPlugin() {

    init {
        instance = this
    }

    override fun onEnable() {
        /* TODO:
            - Chat Listener
            - Join/Leave Listener
            - Commands
            - Warps
            - Point Locator
        */

        /* Listeners */

        ChatListener(instance)

    }

    companion object {
        lateinit var instance: xLite
            private set
    }
}