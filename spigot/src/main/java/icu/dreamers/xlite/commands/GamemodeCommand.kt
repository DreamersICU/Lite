package icu.dreamers.xlite.commands

import icu.dreamers.xlite.util.Chat
import org.bukkit.GameMode
import org.bukkit.command.*
import org.bukkit.entity.Player

class GamemodeCommand(command: PluginCommand): CommandExecutor, TabCompleter {
    init {
        command.setExecutor(this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        if (sender !is Player) return true

        if (!sender.hasPermission("xlite.staff")) {
            sender.sendMessage(Chat.error("You do not have permission to execute this command!"))
            return true
        }

        var mode = sender.gameMode
        if(label.endsWith("gm") || label.endsWith("gamemode")) {
            mode = if (args[0] == "0" || args[0] == "s") {
                GameMode.SURVIVAL
            } else if (args[0] == "1" || args[0] == "c") {
                GameMode.CREATIVE
            } else if (args[0] == "2" || args[0] == "a") {
                GameMode.ADVENTURE
            } else if (args[0] == "3" || args[0] == "sp") {
                GameMode.SPECTATOR
            } else {
                try {
                    GameMode.valueOf(args[0].uppercase())
                } catch (e: IllegalArgumentException) {
                    Chat.error("The gamemode provided is invalid!")
                    return true
                }
            }
        } else if (label.endsWith("gmc")) {
            mode = GameMode.CREATIVE
        } else if (label.endsWith("gms")) {
            mode = GameMode.SURVIVAL
        } else if (label.endsWith("gmsp")) {
            mode = GameMode.SPECTATOR
        } else if (label.endsWith("gma")) {
            mode = GameMode.ADVENTURE
        }

        sender.gameMode = mode
        sender.sendMessage(Chat.success("Your gamemode has been successfully set to " + mode.toString().lowercase() + "."))

        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        val list: MutableList<String> = ArrayList()
        if (alias.endsWith("gm") || alias.endsWith("gamemode") && args.size == 1) {
            list.addAll(
                listOf(
                    "0", "1", "2", "3",
                    "s", "c", "a", "sp",
                    "survival", "creative", "adventure", "spectator"
                )
            )
        }
        return list
    }
}