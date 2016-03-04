package fr.coco.personalchest;

import fr.coco.personalchest.commands.ChestCommand;
import fr.coco.personalchest.commands.CreateChestCommand;
import fr.coco.personalchest.event.RegisterEvents;
import fr.coco.personalchest.event.onInventoryClose;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by coco33910 on 04/03/2016.
 * PersonalChest
 */
public class PersonalChest extends JavaPlugin {

    private static PersonalChest ourInstance;


    @Override
    public void onEnable() {
        RegisterEvents.registerEvents(this, new onInventoryClose());
        getCommand("createchest").setExecutor(new CreateChestCommand());
        getCommand("chest").setExecutor(new ChestCommand());
        ourInstance = this;
    }

    public static PersonalChest getInstance() {
        return ourInstance;
    }


}
