package tech.secretgarden.menu;

import org.bukkit.inventory.Inventory;
import tech.secretgarden.stash.Data.GetMethods;

public class StashMethods {

    private final GetMethods getMethods = new GetMethods();

    public boolean stashHasItems(String uuid) {
        int i = 0;
        Inventory inventory = getMethods.getStashInv(uuid);
        if (inventory.isEmpty()) {
            i = i + 1;
        }
        return i == 0;
    }
}
