package xyz.merith.oven;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.merith.oven.Tests.TestEntrypoint;
import xyz.merith.oven.Tests.TestTools;

import java.io.File;


public class OvenDoor implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ovenlib");
    public static ItemGroup.Builder OVENLIB_GROUP = PolymerItemGroupUtils.builder()
            .displayName(Text.literal("Baked Items"))
            .icon(() -> new ItemStack(Items.BLAST_FURNACE));
    public static RegistryKey<ItemGroup> OVENLIB_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("ovenlib", "itemgroup"));

    @Override
    public void onInitialize() {
        LOGGER.info("Preheating Oven");
        PolymerResourcePackUtils.addModAssets("ovenlib");

        LOGGER.info("Baking ItemGroup");
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of("ovenlib:itemgroup"), OVENLIB_GROUP.build());

        /*
         * This realistically should never run in production,
         * but this allows for building and running tests in a
         * jank as fuck way
        */
        String cwd = System.getProperty("user.dir");
        File cwdFile = new File(cwd);
        File buildGradleFile = new File(cwdFile.getParentFile(), "build.gradle");
        if (cwdFile.getName().equals("run") && buildGradleFile.exists()) {
            new TestEntrypoint().start();
        }

        LOGGER.info("Oven Heated!");
    }
}