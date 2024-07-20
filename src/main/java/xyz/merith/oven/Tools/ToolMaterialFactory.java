package xyz.merith.oven.Tools;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

/**
 * A factory class for creating custom {@link ToolMaterial} instances.
 */
public class ToolMaterialFactory {
    /**
     * Generates a new {@link ToolMaterial} with the specified properties.
     *
     * @param inverseTag        the tag representing blocks that this tool material cannot mine
     * @param itemDurability    the durability of the tool items
     * @param miningSpeed       the mining speed multiplier
     * @param attackDamage      the base attack damage
     * @param enchantability    the enchantability of the tool items
     * @param repairIngredient  a supplier providing the ingredient used to repair the tool items
     * @return a new {@link ToolMaterial} instance with the specified properties
     */
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