package xyz.merith.oven.Tools.Templates;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.*;
import xyz.nucleoid.packettweaker.PacketContext;

/**
 * A custom implementation of an {@link SwordItem} that integrates with the Polymer API for custom item models.
 */
public class Sword extends SwordItem implements PolymerItem {
    /**
     * Constructs a new Sword item with the specified properties.
     *
     * @param polymerItem the item to use as the base for the Polymer model
     * @param material    the material of the sword
     * @param settings    the item settings
     * @param namespace   the namespace (usually the mod ID) for the model identifier
     * @param toolName    the name of the tool, used for generating the model identifier
     */
    public Sword(Item polymerItem, ToolMaterial material, Settings settings, String namespace, String toolName) {
        super(material, material.attackDamageBonus(), material.speed(), settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return this.asItem();
    }
}