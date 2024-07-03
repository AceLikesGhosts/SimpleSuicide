package me.ace.simplesuicide;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player owner = (Player) commandSender;
        if (args.length == 0 || !commandSender.isOp()) {
            owner.setHealth(0);
            owner.sendMessage(ChatColor.RED + "You killed yourself.");
            return true;
        }

        Player player = Bukkit.getServer().getPlayer(args[0]);
        if (player == null || !player.isOnline()) {
            owner.sendMessage(ChatColor.RED + "Failed to find user \"" + args[0] + "\".");
            return true;
        }

        player.setHealth(0);
        owner.sendMessage(ChatColor.RED + "Killed \"" + player.getName() + "\".");

        return true;
    }
}
