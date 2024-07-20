package xyz.merith.oven.ItemGroup;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
        return createGroup(id, Text.literal("Baked Items"));
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
}
