package net.GunWarOnline_server.plugin.Damage_changer.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
	{
		Player target = (Player)sender;
		String prefix = ChatColor.GOLD + "[NoBreak]"+ChatColor.RESET;
		if(args.length < 1)
		{
			target.sendMessage(prefix + "==More information about plugins==");
			target.sendMessage(prefix + "Author :kojima1021");
			target.sendMessage(prefix + "Version : 0.0.1");
			target.sendMessage(prefix + "Thanks for using!");
			return true;
		}
		return false;
}
}