package teamzesa.command;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import teamzesa.announcer.ComponentExchanger;
import teamzesa.userValue.UserIOHandler;
import teamzesa.userValue.UserHandler;

import java.io.File;

public class SaveUserData implements CommandExecutor {
    private static UserIOHandler userIoHandler;
    private static UserHandler userHandler;
    private final File userDataFile;

    public SaveUserData(File userDataFile) {
        userIoHandler = UserIOHandler.getIOHandler();
        userHandler = UserHandler.getUserHandler();
        this.userDataFile = userDataFile;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ComponentExchanger.playerAnnouncer((Player)sender, "권한이 없습니다.", "RED");
            return false;
        }

        userHandler.saveAllUserData();
        userIoHandler.outputUserData(userDataFile);
        Bukkit.getLogger().info("Success to saving UserData");
        return true;
    }
}
