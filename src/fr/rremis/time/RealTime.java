package fr.rremis.time;

import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class RealTime extends JavaPlugin implements CommandExecutor {
	
	@Override
	public void onEnable(){
		instance = this;
		
		getCommand("realtime").setExecutor(this);
		log("RealTime ON");
	}
	
	@Override
	public void onDisable(){
		log("RealTime OFF");
	}
	
	private static RealTime instance;
	public static RealTime getInstance(){
		return instance;
	}
	
	public String getPrefix(){
		return ChatColor.DARK_GREEN+"RealTime"+ChatColor.DARK_GRAY+"» "+ChatColor.GRAY;
	}
	
	public void log(String message){
		System.out.println("[RT] "+message);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("realtime")) {
			Date date = new Date(System.currentTimeMillis());
			p.sendMessage(getPrefix()+"Currently it's "+ChatColor.AQUA+date.getHours()+":"+date.getMinutes());
			return true;
		}
		return true;
	}

}
