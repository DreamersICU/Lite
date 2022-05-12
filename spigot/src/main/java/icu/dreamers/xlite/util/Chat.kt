package icu.dreamers.xlite.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

object Chat {
    private fun prefix(char: Char, color: TextColor) = Component.text()
        .color(color)
        .append(Component.text("$char", NamedTextColor.WHITE))
        .build()
}