package xyz.merith.oven.Armors;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;

import java.util.EnumMap;

public class ArmorMaterialFactory {
    // TODO: Actually make this work
    public static RegistryEntry<ArmorMaterial> getDefault() {
        return ArmorMaterials.CHAIN;
    }
}
