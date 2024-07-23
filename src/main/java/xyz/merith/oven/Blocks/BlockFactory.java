package xyz.merith.oven.Blocks;

import eu.pb4.polymer.blocks.api.BlockModelType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.merith.oven.Blocks.Templates.CustomBlock;

/**
 * A factory class for creating and registering custom blocks.
 */
public class BlockFactory {

    /**
     * Registers a custom block with the specified namespace and base name.
     *
     * @param namespace the namespace for the block (usually the mod ID)
     * @param basename  the base name for the block, which will be used to generate block IDs
     * @param settings  the settings of the block
     * @return the registered block
     */
    public Block registerSolidBlock(String namespace, String basename, AbstractBlock.Settings settings) {
        Block newBlock = new CustomBlock(namespace, basename, settings, BlockModelType.FULL_BLOCK);

        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(namespace, basename), newBlock);

        // Register the block item
        Item blockItem = new BlockItem(registeredBlock, new Item.Settings());
        Registry.register(Registries.ITEM, Identifier.of(namespace, basename), blockItem);
        return registeredBlock;
    }

    public Block registerTransparentBlock(String namespace, String basename, AbstractBlock.Settings settings) {
        Block newBlock = new CustomBlock(namespace, basename, settings, BlockModelType.TRANSPARENT_BLOCK);

        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(namespace, basename), newBlock);

        // Register the block item
        Item blockItem = new BlockItem(registeredBlock, new Item.Settings());
        Registry.register(Registries.ITEM, Identifier.of(namespace, basename), blockItem);
        return registeredBlock;
    }
}
