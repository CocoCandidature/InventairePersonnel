package fr.coco.personalchest.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 * Created by coco33910 on 04/03/2016.
 * RegisterEvents
 */
public class RegisterEvents {


    public static void registerEvents(Plugin p, Listener... listeners) {

        PluginManager pm = Bukkit.getPluginManager();

        for (int i = 0; i < listeners.length; i++) {

            pm.registerEvents(listeners[i], p);

        }


    }


}

