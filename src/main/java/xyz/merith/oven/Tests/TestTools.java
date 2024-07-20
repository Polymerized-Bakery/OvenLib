package xyz.merith.oven.Tests;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import xyz.merith.oven.Tools.ToolFactory;
import xyz.merith.oven.Tools.ToolMaterialFactory;

public class TestTools {
    public static ToolMaterial TOOL_MATERIAL = ToolMaterialFactory.Generate(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1024,
            10F,
            5F,
            10,
            () -> Ingredient.ofItems(Items.DIRT)
    );
}
