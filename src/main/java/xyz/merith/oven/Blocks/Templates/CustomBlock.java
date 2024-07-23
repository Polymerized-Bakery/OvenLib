package xyz.merith.oven.Blocks.Templates;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

/**
 * CustomBlock is a block class that extends the Minecraft Block class and implements the PolymerTexturedBlock interface.
 * It allows for the creation of custom textured blocks that can have different block states for server and client sides.
 */
public class CustomBlock extends Block implements PolymerTexturedBlock {
    private final BlockState polymerBlock;

    /**
     * Constructor for creating a CustomBlock with default settings.
     *
     * @param namespace The namespace for the block's identifier.
     * @param blockname The name of the block.
     */
    public CustomBlock(String namespace, String blockname) {
        super(AbstractBlock.Settings.create());
        this.polymerBlock = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(Identifier.of(namespace, "block/" + blockname)));
    }

    /**
     * Constructor for creating a CustomBlock with specified settings.
     *
     * @param namespace The namespace for the block's identifier.
     * @param blockname The name of the block.
     * @param settings  The settings for the block.
     */
    public CustomBlock(String namespace, String blockname, Settings settings) {
        super(settings);
        this.polymerBlock = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(Identifier.of(namespace, "block/" + blockname)));
    }

    /**
     * Constructor for creating a CustomBlock with specified settings and block model type.
     *
     * @param namespace     The namespace for the block's identifier.
     * @param blockname     The name of the block.
     * @param settings      The settings for the block.
     * @param blockModelType The block model type.
     */
    public CustomBlock(String namespace, String blockname, Settings settings, BlockModelType blockModelType) {
        super(settings);
        this.polymerBlock = PolymerBlockResourceUtils.requestBlock(blockModelType, PolymerBlockModel.of(Identifier.of(namespace, "block/" + blockname)));
    }

    /**
     * Generic method used for replacing BlockStates in case of no player context.
     * It also controls some server-side things like collisions.
     *
     * @param state Server side/real BlockState.
     * @return BlockState visible on client.
     */
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return this.polymerBlock;
    }

    /**
     * Main method used for replacing BlockStates for players.
     * Keep in mind you should ideally use blocks with the same hitbox as generic/non-player ones!
     *
     * @param state  Server side BlockState.
     * @param player Player viewing it.
     * @return Client side BlockState.
     */
    @Override
    public BlockState getPolymerBlockState(BlockState state, ServerPlayerEntity player) {
        return PolymerTexturedBlock.super.getPolymerBlockState(state, player);
    }

    /**
     * This method is called when the block gets sent to the player.
     * Allows adding client-only BlockEntities (for signs, heads, etc).
     *
     * @param blockState Real BlockState of the block.
     * @param pos        Position of the block. Keep in mind it's mutable,
     *                   so make sure to use {@link BlockPos.Mutable#toImmutable()}
     *                   in case of using in packets, as it's reused for other positions!
     * @param player     Player packets should be sent to.
     */
    @Override
    public void onPolymerBlockSend(BlockState blockState, BlockPos.Mutable pos, ServerPlayerEntity player) {
        PolymerTexturedBlock.super.onPolymerBlockSend(blockState, pos, player);
    }

    /**
     * You can override this method in case of issues with light updates of this block.
     * In most cases, it's not needed.
     *
     * @param blockState The BlockState of the block.
     * @return true if light updates should be forced, false otherwise.
     */
    @Override
    public boolean forceLightUpdates(BlockState blockState) {
        return PolymerTexturedBlock.super.forceLightUpdates(blockState);
    }

    /**
     * Overrides the breaking particle used by the block.
     *
     * @param state  The BlockState of the block.
     * @param player The player breaking the block.
     * @return The BlockState to be used for the breaking event.
     */
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return PolymerTexturedBlock.super.getPolymerBreakEventBlockState(state, player);
    }
}
