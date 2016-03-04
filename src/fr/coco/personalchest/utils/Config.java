package fr.coco.personalchest.utils;

import fr.coco.personalchest.PersonalChest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by coco33910 on 04/03/2016.
 * Config
 */
public class Config {


        private String nameFile;
        private File file;
        private FileConfiguration fileConfig;


        public Config(String nameFile) {
            this.nameFile = nameFile;


            file = new File(PersonalChest.getInstance().getDataFolder() + "/playerdata/", nameFile + ".yml");


            if (!file.exists()) {

                try {
                    file.createNewFile();
                    file.mkdir();


                } catch (IOException e) {
// TODO Auto-generated catch blocke.printStackTrace();
                }

            }
            fileConfig = YamlConfiguration.loadConfiguration(file);

        }

        public File getFile() {
            return file;
        }

        public String getNameFile() {
            return nameFile;
        }

        public FileConfiguration getFileConfig() {
            return fileConfig;
        }
    public void save(){
        try {
            getFileConfig().save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


