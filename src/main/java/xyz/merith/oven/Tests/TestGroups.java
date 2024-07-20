package xyz.merith.oven.Tests;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.ItemGroup.GroupFactory;
import xyz.merith.oven.OvenDoor;
import xyz.merith.oven.Tools.ToolFactory;

public class TestGroups {
    public TestGroups() {
        OvenDoor.LOGGER.info("Generating Test Groups");
        ToolFactory.Tools NEW_TOOLS = new ToolFactory().registerTools("ovenlib", "test", TestTools.TOOL_MATERIAL);
        ItemGroup.Builder ITEM_GROUP1 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"));
        ItemGroup.Builder ITEM_GROUP2 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"), Text.literal("Baked Group Literal"));
        ItemGroup.Builder ITEM_GROUP3 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"), Text.translatable("ovenlib.itemgroup"));
        ItemGroup.Builder ITEM_GROUP4 = new GroupFactory().createGroup(Identifier.of("ovenlib:testgroup"), Text.translatable("ovenlib.itemgroup"), Items.DIAMOND);


        ITEM_GROUP1.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
        });
        ITEM_GROUP1.entries((ctx, e) -> {
            e.add(Items.GLOW_ITEM_FRAME);
        }).build();
        ITEM_GROUP2.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
        });
        ITEM_GROUP2.entries((ctx, e) -> {
            e.add(Items.GLOW_ITEM_FRAME);
        }).build();
        ITEM_GROUP3.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
        });
        ITEM_GROUP3.entries((ctx, e) -> {
            e.add(Items.GLOW_ITEM_FRAME);
        }).build();
        ITEM_GROUP4.entries((ctx, e) -> {
            e.add(Items.ITEM_FRAME);
        });
        ITEM_GROUP4.entries((ctx, e) -> {
            e.add(Items.GLOW_ITEM_FRAME);
        }).build();

    }
}
