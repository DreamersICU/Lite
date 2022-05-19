package icu.dreamers.xlite.util

import net.md_5.bungee.api.ChatColor

object Chat {
//    val info = prefix('鎓', TextColor.color(0x238de0))
//    val error = prefix('冈', TextColor.color(0xd64043))
//    val warn = prefix('鏻', TextColor.color(0xf77622))
//    val success = prefix('缎', TextColor.color(0x46a835))

    fun info(msg: String): String {
        var color = "鎓" + ChatColor.of("#238de0") + msg
        return color
    }

    fun error(msg: String): String {
        var color = "冈" + ChatColor.of("#d64043") + msg
        return color
    }

    fun warn(msg: String): String {
        var color = "鏻" + ChatColor.of("#f77622") + msg
        return color
    }

    fun success(msg: String): String {
        var color = "缎" + ChatColor.of("#46a835") + msg
        return color
    }

    fun color(msg: String): String {
        return ChatColor.translateAlternateColorCodes('&', msg)
    }



}