package xyz.merith.oven.Tests;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.ItemGroups.GroupFactory;
import xyz.merith.oven.OvenDoor;
import xyz.merith.oven.Tools.ToolFactory;

// Class for testing Item Groups creation
public class TestGroups {
    public TestGroups() {
        OvenDoor.LOGGER.info("Generating Test Groups");

        // Create new tools for testing
        ToolFactory.Tools NEW_TOOLS = new ToolFactory().registerTools("ovenlib", "test", TestTools.TOOL_MATERIAL);

        // Test Group without a name or icon
        ItemGroup.Builder ITEM_GROUP1 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup1"));

        /*
            Note: `.entries((ctx, e) -> {})` can only be called once.
            Subsequent calls will overwrite previous entries.
        */
        ITEM_GROUP1.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
        });

        // Register the first test group
        /*
            Issue: https://github.com/Patbox/polymer/issues/141
            Registering the group again with the same identifier will create a duplicate group with mostly empty content.
        */
        new GroupFactory().register(Identifier.of("ovenlib:testgroup1"), ITEM_GROUP1.build());

        // Test Group with a literal name
        ItemGroup.Builder ITEM_GROUP2 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup2"), Text.literal("Baked Group Literal"));

        /*
            Adding multiple items at once.
            You can iterate over an array of items to add them.
        */
        ITEM_GROUP2.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
            e.add(Items.GLOW_ITEM_FRAME);
        });

        // Register the second test group
        new GroupFactory().register(Identifier.of("ovenlib:testgroup2"), ITEM_GROUP2.build());

        // Test Group with a translatable name and an icon
        ItemGroup.Builder ITEM_GROUP4 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup4"), Text.translatable("ovenlib.itemgroup"), Items.DIAMOND);

        /*
            Register a set of items generated from ToolFactory.registerTools().
        */
        ITEM_GROUP4.entries((ctx, e) -> {
            e.add(NEW_TOOLS.AXE);
            e.add(NEW_TOOLS.HOE);
            e.add(NEW_TOOLS.PICKAXE);
            e.add(NEW_TOOLS.SHOVEL);
            e.add(NEW_TOOLS.SWORD);
        });

        // Register the fourth test group
        new GroupFactory().register(Identifier.of("ovenlib:testgroup4"), ITEM_GROUP4.build());
    }
}
