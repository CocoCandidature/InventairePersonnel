package fr.coco.personalchest.event;

import fr.coco.personalchest.helper.Chest;
import org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;

/**
 * Created by coco33910 on 04/03/2016.
 * onInventoryClose
 */
public class onInventoryClose implements Listener {

    @EventHandler
    public void onInventoryClosed(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        Inventory inv = e.getInventory();

        if (inv.getName().equalsIgnoreCase(Chest.getInstance().getInv2().getName())) {
            File f = new File("PersonalChest/playerdata/", player.getName() + ".yml");
            try {
                FileUtils.deleteDirectory(f);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                new Chest(player, inv);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }


    }


}
