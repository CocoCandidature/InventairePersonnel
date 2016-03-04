package fr.coco.personalchest.commands;

import fr.coco.personalchest.helper.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * Created by coco33910 on 04/03/2016.
 * ChestCommand
 */
public class ChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        Player player = (Player) commandSender;

        if (cmd.getName().equalsIgnoreCase("chest")) {

            Chest.getInstance().openChestWithItem(player);

        }

        return false;
    }

}