package fr.coco.personalchest.helper;

import fr.coco.personalchest.PersonalChest;
import fr.coco.personalchest.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

/**
 * Created by coco33910 on 04/03/2016.
 * Chest
 */
public class Chest {

    private static Chest instance = new Chest();


    private Player owner;
    private Config config;
    private Inventory inv;
    private Inventory inv2;

    public Chest(Player owner, Inventory inv) throws IOException {

        this.owner = owner;
        this.inv = inv;
        inv2 = Bukkit.createInventory(owner, InventoryType.PLAYER, "§cYour chest");


        config = new Config(owner.getName());


        config.getFileConfig().set("chest.owner", owner.getName());
        for (int i = 0; i < inv.getSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (stack == null) {
                stack = new ItemStack(Material.AIR);
            }

            config.getFileConfig().set("chest.inventory.is" + i + ".item", stack);
            config.getFileConfig().set("chest.inventory" + ".is" + i + ".number", i);

        }


        config.save();
        owner.sendMessage("§cVotre inventaire a été sauvegardé.");




    }

    public Player getOwner() {
        return this.owner;
    }


    public Config getConfig() {
        return config;
    }


    public void openChestWithItem(Player player) {
        File f = new File(PersonalChest.getInstance().getDataFolder() + "/playerdata/", player.getName() + ".yml");
        inv2 = Bukkit.createInventory(player, InventoryType.PLAYER, "§cYour Chest");

        if (f == null) {
            player.sendMessage("§cVous n'avez pas d'inventaire enregistré ^^");
            return;
        }

        Config c = new Config(player.getName());


        for (int i = 0; i < 36; i++) {
            ItemStack stack = c.getFileConfig().getItemStack("chest.inventory.is" + i + ".item");
            int slot = c.getFileConfig().getInt("chest.inventory.is" + i + ".number");

            inv2.setItem(slot, stack);

        }
        player.closeInventory();
        player.openInventory(inv2);


    }

    private Chest() {

    }

    public static Chest getInstance() {
        return instance;
    }

    public Inventory getInv() {
        return inv;
    }

    public Inventory getInv2() {
        return inv2;
    }
}
