package xyz.merith.oven.Armors;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

/**
 * A custom implementation of an {@link ArmorItem} that integrates with the Polymer API for custom item models.
 */
public class ArmorTemplate extends ArmorItem implements PolymerItem {
    private final PolymerModelData model;

    /**
     * Constructs a new Helmet item.
     *
     * @param polymerItem the base item to be used as a model for this armor item
     * @param material    the armor material used for this helmet
     * @param armorType   the type of armor (e.g., Type.HELMET)
     * @param settings    the item settings, such as durability and enchantability
     * @param namespace   the namespace for this item (usually the mod ID)
     * @param armorName   the name of the armor item, used to generate the item model identifier
     */
    public ArmorTemplate(Item polymerItem, RegistryEntry<ArmorMaterial> material, Type armorType, Settings settings, String namespace, String armorName) {
        super(material, armorType , settings);
        this.model = PolymerResourcePackUtils.requestModel(polymerItem, Identifier.of(namespace, "item/"+armorName));
    }
    /**
     * Gets the Polymer item to be displayed for the given player.
     *
     * @param stack  the item stack
     * @param player the player entity, can be null
     * @return the Polymer item to be displayed
     */
    @Override
    public Item getPolymerItem(ItemStack stack, ServerPlayerEntity player) {
        return this.model.item();
    }

    /**
     * Gets the custom model data value for the Polymer item.
     *
     * @param itemStack the item stack
     * @param player    the player entity, can be null
     * @return the custom model data value
     */
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return model.value();
    }
}
