package xyz.merith.oven.Armors;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.entry.RegistryEntry;
import xyz.nucleoid.packettweaker.PacketContext;

/**
 * A custom implementation of an {@link ArmorItem} that integrates with the Polymer API for custom item models.
 */
public class ArmorTemplate extends ArmorItem implements PolymerItem {
    /**
     * Constructs a new Helmet item.
     *
     * @param polymerItem the base item to be used as a model for this armor item
     * @param material    the armor material used for this helmet
     * @param armorType   the type of armor (e.g., EquipmentType.HELMET)
     * @param settings    the item settings, such as durability and enchantability
     * @param namespace   the namespace for this item (usually the mod ID)
     * @param armorName   the name of the armor item, used to generate the item model identifier
     */
    public ArmorTemplate(Item polymerItem, ArmorMaterial material, EquipmentType armorType, Item.Settings settings, String namespace, String armorName) {
        super(material, armorType , settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return null;
    }
}
