package me.alexpado.pmc;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.*;

/**
 * Entry point for the template plugin. You should edit
 * this comment by explaining the main purpose of your
 * plugin
 *
 * You should also edit these tags below.
 *
 * @author alexpado
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class PluginEntry extends JavaPlugin {
	@Override
	public void onLoad() {
		// TODO : Do something if your plugin needs it
		logToFile("onLoad");
	}

	@Override
	public void onEnable() {
		logToFile("onEnable");
		// Copy the config.yml in the plugin configuration folder if it doesn't exists.
		this.saveDefaultConfig();
		// TODO : Do something if your plugin needs it (registering commands / listeners)
	}

	@Override
	public void onDisable() {
		logToFile("onDisable");
		// TODO : Do something if your plugin needs it (saving custom configs, clearing cache, closing connections...)
	}

	public void logToFile(String message) {
		try {
			File dataFolder = getDataFolder();
			if (!dataFolder.exists()) {
				dataFolder.mkdir();
			}
			File saveTo = new File(getDataFolder(), "data.txt");
			if (!saveTo.exists()) {
				saveTo.createNewFile();
			}
			FileWriter fw = new FileWriter(saveTo, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(message);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
