package teamzesa.worldSet;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.purpurmc.purpur.event.inventory.AnvilUpdateResultEvent;
import teamzesa.dataValue.EnchantValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Anvil implements Listener {

    @EventHandler
    public void onAnvil(AnvilUpdateResultEvent e) {

        ItemStack leftStuff = e.getInventory().getItem(0);
        ItemStack rightStuff = e.getInventory().getItem(1);

        if (leftStuff == null || rightStuff == null)
            return;


        List<EnchantValue> leftOption = new ArrayList<>();
        List<EnchantValue> rightOption = new ArrayList<>();
        Map<Enchantment, Integer> leftStuffEnchant = leftStuff.getEnchants();
        Map<Enchantment, Integer> rightStuffEnchant = rightStuff.getEnchants();


        for (Map.Entry<Enchantment,Integer> entry : leftStuffEnchant.entrySet()) {
            EnchantValue enchantValue = new EnchantValue(entry.getKey(), entry.getValue());
            leftOption.add(enchantValue);
        }
        leftOption.forEach(System.out::println);


        for (Map.Entry<Enchantment,Integer> entry : rightStuffEnchant.entrySet()) {
            EnchantValue enchantValue = new EnchantValue(entry.getKey(), entry.getValue());
            rightOption.add(enchantValue);
        }
        rightOption.forEach(System.out::println);
    }
}
