package xyz.merith.oven;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.merith.oven.ToolTemplates.*;

public class ToolFactory {
    public static class Tools {
        public final Item AXE;
        public final Item HOE;
        public final Item PICKAXE;
        public final Item SHOVEL;
        public final Item SWORD;

        public Tools(Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) {
            this.AXE = axe;
            this.HOE = hoe;
            this.PICKAXE = pickaxe;
            this.SHOVEL = shovel;
            this.SWORD = sword;
        }
    }

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