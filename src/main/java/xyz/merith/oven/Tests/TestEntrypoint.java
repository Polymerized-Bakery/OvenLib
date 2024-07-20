/*
 * TestEntrypoint.java
 *
 * Code found in these tests can be taken and reused without credit as they serve a dual purpose
 * 1) To allow me to test what does and doesnt work with ovenlib
 * 2) To serve as examples for how to actually use ovenlib
 *
 * PLEASE DO READ THE COMMENTS THEY WILL HELP YOU UNDERSTAND THE NUANCES
 */

package xyz.merith.oven.Tests;

import xyz.merith.oven.OvenDoor;

public class TestEntrypoint {
    public void start() {
        OvenDoor.LOGGER.info("Generating Tests");
        new TestGroups();
    }

}
