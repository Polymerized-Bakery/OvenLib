package xyz.merith.oven.Tests;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.Armors.ArmorFactory;
import xyz.merith.oven.Blocks.BlockFactory;
import xyz.merith.oven.ItemGroups.GroupFactory;
import xyz.merith.oven.OvenDoor;
import xyz.merith.oven.Tools.ToolFactory;
import xyz.merith.oven.Tools.ToolMaterialFactory;

// Class for testing Item Groups creation
public class TestGroups {
    public TestGroups() {
        OvenDoor.LOGGER.info("Generating Test Groups");

        ToolMaterial TOOL_MATERIAL = ToolMaterialFactory.Generate(
                BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                1024,
                10F,
                5F,
                10,
                () -> Ingredient.ofItems(Items.DIRT)
        );

        // Create new tools for testing
        ToolFactory.Tools NEW_TOOLS = new ToolFactory().registerTools("ovenlib", "test", TOOL_MATERIAL);
        ArmorFactory.Armors NEW_ARMOR = new ArmorFactory().registerArmors("ovenlib", "test");
        Block NEW_BLOCK = new BlockFactory().registerBlock("ovenlib", "test_block", AbstractBlock.Settings.create());
        // Test Group with a translatable name and an icon
        ItemGroup.Builder ITEM_GROUP = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"), Text.translatable("ovenlib.itemgroup"), Items.DIAMOND);

        ITEM_GROUP.entries((ctx, e) -> {
            e.add(NEW_TOOLS.AXE);
            e.add(NEW_TOOLS.HOE);
            e.add(NEW_TOOLS.PICKAXE);
            e.add(NEW_TOOLS.SHOVEL);
            e.add(NEW_TOOLS.SWORD);
            e.add(NEW_ARMOR.HELMET);
            e.add(NEW_ARMOR.BODY);
            e.add(NEW_ARMOR.LEGGINGS);
            e.add(NEW_ARMOR.BOOTS);
            e.add(NEW_BLOCK);
        });

        // Register the fourth test group
        new GroupFactory().register(Identifier.of("ovenlib:testgroup"), ITEM_GROUP.build());
    }
}
