package xyz.merith.oven.Tests;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.ItemGroups.GroupFactory;
import xyz.merith.oven.OvenDoor;
import xyz.merith.oven.Tools.ToolFactory;

public class TestGroups {
    public TestGroups() {
        OvenDoor.LOGGER.info("Generating Test Groups");
        // Test Creating new tools
        ToolFactory.Tools NEW_TOOLS = new ToolFactory().registerTools("ovenlib", "test", TestTools.TOOL_MATERIAL);

        ItemGroup.Builder ITEM_GROUP = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"), Text.literal("Original group"));
        // Test Group without name or icon
        ItemGroup.Builder ITEM_GROUP1 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup1"));
        /*
            At first, I thought adding an entry, and then doing it again
            later as shown here for group-1 would work, it does not,
            Adding entries must be done all at once,
         */
        ITEM_GROUP1.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);        // DOES NOT GET ADDED
        });
        ITEM_GROUP1.entries((ctx, e) -> {
            e.add(Items.GLOW_ITEM_FRAME);   // BECAUSE THIS OVERRIDES IT
        });
        new GroupFactory().register(Identifier.of("ovenlib:testgroup1"), ITEM_GROUP1.build());

        // Rebuilding the group does not override it, once you build it the first time that's it.
        new GroupFactory().register(Identifier.of("ovenlib:testgroup"), ITEM_GROUP.build());
        new GroupFactory().register(Identifier.of("ovenlib:testgroup"), ITEM_GROUP1.build());

        // Test Group with literal name
        ItemGroup.Builder ITEM_GROUP2 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup2"), Text.literal("Baked Group Literal"));
        /*
            This is how you add multiple items at once.
            Note you *can* iterate over an array of Items for this
         */
        ITEM_GROUP2.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
            e.add(Items.GLOW_ITEM_FRAME);
        });

        // Registering an empty item group, what do you expect?
        new GroupFactory().register(Identifier.of("ovenlib:testgroup2"), ITEM_GROUP2.build());

        // Test Group with translatable name
        ItemGroup.Builder ITEM_GROUP3 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup3"), Text.translatable("ovenlib.itemgroup"));
        new GroupFactory().register(Identifier.of("ovenlib:testgroup3"), ITEM_GROUP3.build());

        // Test Group with Translatable name and Icon
        ItemGroup.Builder ITEM_GROUP4 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup4"), Text.translatable("ovenlib.itemgroup"), Items.DIAMOND);
        // Registering a set of items generated from ToolsFactory.registerTools()
        ITEM_GROUP4.entries((ctx, e) -> {
            e.add(NEW_TOOLS.AXE);
            e.add(NEW_TOOLS.HOE);
            e.add(NEW_TOOLS.PICKAXE);
            e.add(NEW_TOOLS.SHOVEL);
            e.add(NEW_TOOLS.SWORD);
        });
        new GroupFactory().register(Identifier.of("ovenlib:testgroup4"), ITEM_GROUP4.build());

    }
}
