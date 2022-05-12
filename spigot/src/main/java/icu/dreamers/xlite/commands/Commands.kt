package icu.dreamers.xlite.commands

import cloud.commandframework.bukkit.CloudBukkitCapabilities
import cloud.commandframework.execution.AsynchronousCommandExecutionCoordinator
import cloud.commandframework.minecraft.extras.MinecraftExceptionHandler
import cloud.commandframework.paper.PaperCommandManager
import icu.dreamers.xlite.xLite
import org.bukkit.command.CommandSender
import java.util.function.Function

class Commands(plugin: xLite) {
    init {
        val commandManager = PaperCommandManager(
            plugin,
            AsynchronousCommandExecutionCoordinator.newBuilder<CommandSender>().build(),
            Function.identity(),
            Function.identity()
        )

        if (commandManager.queryCapability(CloudBukkitCapabilities.NATIVE_BRIGADIER)) {
            commandManager.registerBrigadier()
        }

        if (commandManager.queryCapability(CloudBukkitCapabilities.ASYNCHRONOUS_COMPLETION)) {
            commandManager.registerAsynchronousCompletions()
        }

        MinecraftExceptionHandler<CommandSender>()
            .withArgumentParsingHandler()
            .withInvalidSenderHandler()
            .withInvalidSyntaxHandler()
            .withNoPermissionHandler()
            .withCommandExecutionHandler()
            .withDecorator(/*Chat.error.append(it)*/null)
            .apply(commandManager) { it }
    }
}