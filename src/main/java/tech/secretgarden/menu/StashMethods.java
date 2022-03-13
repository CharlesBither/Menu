package tech.secretgarden.menu;

import org.bukkit.inventory.Inventory;
import tech.secretgarden.stash.GetMethods;
import tech.secretgarden.stash.Stash;

import java.util.UUID;

public class StashMethods {

    private Stash stash = Stash.getInstance();
    private GetMethods getMethods = new GetMethods();

    public boolean stashHasItems(String uuid) {
        int i = 0;
        Inventory inventory = getMethods.getStashInv(uuid);
        if (inventory.isEmpty()) {
            i = i + 1;
        }
        return i == 0;
    }
}
