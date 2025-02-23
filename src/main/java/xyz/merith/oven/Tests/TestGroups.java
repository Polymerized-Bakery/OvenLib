package xyz.merith.oven.Tests;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.Armors.ArmorFactory;
import xyz.merith.oven.Blocks.BlockFactory;
import xyz.merith.oven.ItemGroups.GroupFactory;
import xyz.merith.oven.OvenDoor;
import xyz.merith.oven.Tools.ToolFactory;


// Class for testing Item Groups creation
public class TestGroups {
    public TestGroups() {
        OvenDoor.LOGGER.info("Generating Test Groups");

        OvenDoor.LOGGER.info("TEST: Registering Test Material");
        ToolMaterial TOOL_MATERIAL = new ToolMaterial(
                BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                1024, // 1024 durability
                10F, // 10F mining speed
                5F, // 5F attack damage
                10, // 10 enchantability
                ItemTags.DIRT // Repair ingredient
        );


        // Create new tools for testing
        OvenDoor.LOGGER.info("TEST: Registering Test Tools");
        ToolFactory.Tools NEW_TOOLS = new ToolFactory().registerTools("ovenlib", "test", TOOL_MATERIAL);
        OvenDoor.LOGGER.info("TEST: Registering Test Armor");
        ArmorFactory.Armors NEW_ARMOR = new ArmorFactory().registerArmors("ovenlib", "test");
        OvenDoor.LOGGER.info("TEST: Registering Test Block: Solid Block");
        Block NEW_SOLID_BLOCK = new BlockFactory().registerSolidBlock("ovenlib", "test_solid_block", AbstractBlock.Settings.create());
        OvenDoor.LOGGER.info("TEST: Registering Test Block: Clear Block");
        Block NEW_CLEAR_BLOCK = new BlockFactory().registerTransparentBlock("ovenlib", "test_clear_block", AbstractBlock.Settings.create());

        // Test Group with a translatable name and an icon
        OvenDoor.LOGGER.info("TEST: Registering Test Group 2");
        ItemGroup.Builder ITEM_GROUP = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"), Text.translatable("ovenlib.itemgroup"), Items.DIAMOND);

        OvenDoor.LOGGER.info("TEST: Adding items to Test Group 3");
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
            e.add(NEW_SOLID_BLOCK);
            e.add(NEW_CLEAR_BLOCK);
        });

        // Register the fourth test group
        OvenDoor.LOGGER.info("TEST: Registering Test Group 4");
        new GroupFactory().register(Identifier.of("ovenlib:testgroup"), ITEM_GROUP.build());
    }
}
