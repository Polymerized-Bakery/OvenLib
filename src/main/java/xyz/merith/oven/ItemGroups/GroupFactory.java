package xyz.merith.oven.ItemGroups;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.core.impl.InternalServerRegistry;
import eu.pb4.polymer.core.impl.PolymerImpl;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.OvenDoor;

/**
 * A factory class for creating custom {@link ItemGroup} builders with the Polymer API.
 */
public class GroupFactory {

    /**
     * Creates a new {@link ItemGroup.Builder} with the specified identifier and a default display name "Baked Items".
     *
     * @param id the identifier for the item group
     * @return a new {@link ItemGroup.Builder} instance
     */
    public ItemGroup.Builder createGroup(Identifier id) {
        return createGroup(id, Text.literal("Unnamed Bakery"));
    }

    /**
     * Creates a new {@link ItemGroup.Builder} with the specified identifier and display name.
     *
     * @param id   the identifier for the item group
     * @param name the display name for the item group
     * @return a new {@link ItemGroup.Builder} instance
     */
    public ItemGroup.Builder createGroup(Identifier id, MutableText name) {
        return createGroup(id, name, Items.FURNACE);
    }

    /**
     * Creates a new {@link ItemGroup.Builder} with the specified identifier, display name, and icon item.
     *
     * @param id   the identifier for the item group
     * @param name the display name for the item group
     * @param icon the item to use as the icon for the item group
     * @return a new {@link ItemGroup.Builder} instance
     */
    public ItemGroup.Builder createGroup(Identifier id, MutableText name, Item icon) {
        ItemGroup.Builder NEW_BUILDER = PolymerItemGroupUtils.builder()
                .displayName(name)
                .icon(() -> new ItemStack(icon));
        return NEW_BUILDER;
    }


    /**
     * A convenience method that acts as a shortcut for registering a custom {@link ItemGroup} with the specified identifier.
     * <p>
     * This method internally calls {@link PolymerItemGroupUtils#registerPolymerItemGroup(Identifier, ItemGroup)} to perform
     * the actual registration.
     * </p>
     *
     * @param identifier the identifier for the item group
     * @param group      the item group to be registered
     */
    public void register(Identifier identifier, ItemGroup group) {
        if (InternalServerRegistry.ITEM_GROUPS.contains(identifier)) { // TODO: https://github.com/patbox/polymer/pull/142
            OvenDoor.LOGGER.warn("Group {}:{} is already registered, skipping", identifier.getNamespace(), identifier.getPath());
        } else {
            PolymerItemGroupUtils.registerPolymerItemGroup(identifier, group);
            OvenDoor.LOGGER.info("Registering Group {}:{} as {}", identifier.getNamespace(), identifier.getPath(), group.getDisplayName());
        }
    }
}
