package icu.dreamers.xlite.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

object Chat {
    private fun prefix(char: Char, color: TextColor) = Component.text()
        .color(color)
        .append(Component.text("$char", NamedTextColor.WHITE))
        .build()

    val info = prefix('鎓', TextColor.color(0x238de0))
    val error = prefix('冈', TextColor.color(0xd64043))
    val warn = prefix('鏻', TextColor.color(0xf77622))
    val success = prefix('缎', TextColor.color(0x46a835))

}