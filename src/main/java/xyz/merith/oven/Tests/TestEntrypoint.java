package xyz.merith.oven.Tests;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.merith.oven.ItemGroup.GroupFactory;
import xyz.merith.oven.OvenDoor;
import xyz.merith.oven.Tools.ToolFactory;

public class TestEntrypoint {
    public void start() {
        OvenDoor.LOGGER.info("Generating Tests");
        new TestGroups();
    }

}
