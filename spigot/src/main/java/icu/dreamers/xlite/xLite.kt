package icu.dreamers.xlite

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
    }

    companion object {
        lateinit var instance: xLite
            private set
    }
}