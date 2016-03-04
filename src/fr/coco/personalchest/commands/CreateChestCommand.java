package fr.coco.personalchest.commands;

import fr.coco.personalchest.helper.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * Created by coco33910 on 04/03/2016.
 * CreateChestCommand
 */
public class CreateChestCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        Player player = (Player) commandSender;

        if (cmd.getName().equalsIgnoreCase("createChest")) {


            try {
                new Chest(player, player.getInventory());
                player.getInventory().clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
