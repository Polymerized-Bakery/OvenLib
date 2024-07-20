package xyz.merith.oven;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.merith.oven.Tests.TestEntrypoint;

import java.io.File;


public class OvenDoor implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ovenlib");
    @Override
    public void onInitialize() {
        LOGGER.info("Preheating Oven");
        PolymerResourcePackUtils.addModAssets("ovenlib");

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