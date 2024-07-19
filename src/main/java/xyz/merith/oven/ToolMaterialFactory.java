package xyz.merith.oven;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public class ToolMaterialFactory {
    public static ToolMaterial Generate(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        return new ToolMaterial() {
            private final Supplier<Ingredient> memoizedRepairIngredient = Suppliers.memoize(repairIngredient::get);

            @Override
            public int getDurability() {
                return itemDurability;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return miningSpeed;
            }

            @Override
            public float getAttackDamage() {
                return attackDamage;
            }

            public TagKey<Block> getInverseTag() {
                return inverseTag;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return memoizedRepairIngredient.get();
            }
        };
    }
}