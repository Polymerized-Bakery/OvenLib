package xyz.merith.oven.Tools;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.merith.oven.Tools.Templates.*;

/**
 * A factory class for creating and registering tool items.
 */
public class ToolFactory {
    public static class Tools {
        public final Item AXE;
        public final Item HOE;
        public final Item PICKAXE;
        public final Item SHOVEL;
        public final Item SWORD;

        /**
         * Constructs a new Tools container with the specified tool items.
         *
         * @param axe     the axe item
         * @param hoe     the hoe item
         * @param pickaxe the pickaxe item
         * @param shovel  the shovel item
         * @param sword   the sword item
         */
        public Tools(Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) {
            this.AXE = axe;
            this.HOE = hoe;
            this.PICKAXE = pickaxe;
            this.SHOVEL = shovel;
            this.SWORD = sword;
        }
    }

    /**
     * Registers a set of tool items (axe, hoe, pickaxe, shovel, sword) with the specified namespace and base name.
     *
     * @param namespace the namespace for the tool items (usually the mod ID)
     * @param basename  the base name for the tools (e.g., "copper"), which will be used to generate item IDs
     * @param material  the material of the tools
     * @return a {@link Tools} object containing the registered tool items
     */
    public Tools registerTools(String namespace, String basename, ToolMaterial material) {
        Item axe = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_axe"),
                new Axe(
                        Items.IRON_AXE,
                        material,
                        new Item.Settings()
                                .attributeModifiers(AxeItem.createAttributeModifiers(material, 6.5F, -3.15F)),
                        namespace, basename+"_axe"));

        Item hoe = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_hoe"),
                new Hoe(
                        Items.IRON_HOE,
                        material,
                        new Item.Settings()
                                .attributeModifiers(HoeItem.createAttributeModifiers(material, -1.5F, -2.5F)),
                        namespace, basename+"_hoe"));
        Item pickaxe = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_pickaxe"),
                new Pickaxe(
                        Items.IRON_PICKAXE,
                        material,
                        new Item.Settings()
                                .attributeModifiers(PickaxeItem.createAttributeModifiers(material, 1.0F, -2.8F)),
                        namespace, basename+"_pickaxe"));
        Item shovel = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_shovel"),
                new Shovel(
                        Items.IRON_SHOVEL,
                        material,
                        new Item.Settings()
                                .attributeModifiers(ShovelItem.createAttributeModifiers(material, 1.5F, -3.0F)),
                        namespace, basename+"_shovel"));
        Item sword = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_sword"),
                new Sword(
                        Items.IRON_SWORD,
                        material,
                        new Item.Settings()
                                .attributeModifiers(SwordItem.createAttributeModifiers(material, 3, -2.4F)),
                        namespace, basename+"_sword"));

        return new Tools(axe, hoe, pickaxe, shovel, sword);
    }
}