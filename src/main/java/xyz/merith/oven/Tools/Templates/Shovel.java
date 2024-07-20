package xyz.merith.oven.Tools.Templates;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

/**
 * A custom implementation of an {@link ShovelItem} that integrates with the Polymer API for custom item models.
 */
public class Shovel extends ShovelItem implements PolymerItem {
    private final PolymerModelData model;

    /**
     * Constructs a new Shovel item with the specified properties.
     *
     * @param polymerItem the item to use as the base for the Polymer model
     * @param material    the material of the shovel
     * @param settings    the item settings
     * @param namespace   the namespace (usually the mod ID) for the model identifier
     * @param toolName    the name of the tool, used for generating the model identifier
     */
    public Shovel(Item polymerItem, ToolMaterial material, Settings settings, String namespace, String toolName) {
        super(material, settings);
        this.model = PolymerResourcePackUtils.requestModel(polymerItem, Identifier.of(namespace, "item/"+toolName));
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