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

        // This is the intial creation, in hopes that rebakeOven lets me overwrite this later
        LOGGER.info("Baking ItemGroup");
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of("ovenlib:itemgroup"), OVENLIB_GROUP.build());
        LOGGER.info("Oven Heated!");
    }

    public void rebakeOven() {
        LOGGER.info("ReBaking ItemGroup");
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of("ovenlib:itemgroup"), OVENLIB_GROUP.build());
    }
}