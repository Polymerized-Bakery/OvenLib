package xyz.merith.oven.Armors;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import xyz.merith.oven.Tools.ToolFactory;

public class ArmorFactory {
    public static class Armors {
        public final ArmorItem HELMET;
        public final ArmorItem BODY;
        public final ArmorItem LEGGINGS;
        public final ArmorItem BOOTS;

        /**
         * Constructs a new Armors container with the specified tool items.
         *
         * @param helmet   the helmet item
         * @param body     the body/chest item
         * @param leggings the leggings item
         * @param boots    the boots item
         */
        public Armors(ArmorItem helmet, ArmorItem body, ArmorItem leggings, ArmorItem boots) {
            HELMET = helmet;
            BODY = body;
            LEGGINGS = leggings;
            BOOTS = boots;
        }
    }

    /**
     * Registers a set of tool items (axe, hoe, pickaxe, shovel, sword) with the specified namespace and base name.
     *
     * @param namespace the namespace for the tool items (usually the mod ID)
     * @param basename  the base name for the tools (e.g., "copper"), which will be used to generate item IDs
     * @return a {@link Armors} object containing the registered tool items
     */
    public Armors registerArmors(String namespace, String basename) {
        return registerArmors(namespace, basename, ArmorMaterialFactory.getDefault());
    }

     /**
     * Registers a set of tool items (axe, hoe, pickaxe, shovel, sword) with the specified namespace and base name.
     *
     * @param namespace the namespace for the tool items (usually the mod ID)
     * @param basename  the base name for the tools (e.g., "copper"), which will be used to generate item IDs
     * @param material  the material of the tools
     * @return a {@link ToolFactory.Tools} object containing the registered tool items
     */
    public Armors registerArmors(String namespace, String basename, RegistryEntry<ArmorMaterial> material) {
        ArmorItem helmet = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_helmet"),
                new ArmorTemplate(
                        Items.CHAINMAIL_HELMET,
                        material,
                        ArmorItem.Type.HELMET,
                        new Item.Settings(),
                        namespace, basename+"_helmet"));

        ArmorItem body = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_helmet"),
                new ArmorTemplate(
                        Items.CHAINMAIL_CHESTPLATE,
                        material,
                        ArmorItem.Type.BODY,
                        new Item.Settings(),
                        namespace, basename+"_chestplate"));

        ArmorItem leggings = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_helmet"),
                new ArmorTemplate(
                        Items.CHAINMAIL_LEGGINGS,
                        material,
                        ArmorItem.Type.LEGGINGS,
                        new Item.Settings(),
                        namespace, basename+"_leggings"));

        ArmorItem boots = Registry.register(Registries.ITEM, Identifier.of(namespace, basename+"_helmet"),
                new ArmorTemplate(
                        Items.CHAINMAIL_BOOTS,
                        material,
                        ArmorItem.Type.BOOTS,
                        new Item.Settings(),
                        namespace, basename+"_boots"));

        return new Armors(helmet, body, leggings, boots);
    }
}

