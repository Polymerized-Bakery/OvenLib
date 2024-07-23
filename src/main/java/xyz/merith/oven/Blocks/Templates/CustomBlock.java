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

public class CustomBlock extends Block implements PolymerTexturedBlock {
    private final BlockState polymerBlock;

    public CustomBlock(String namespace, String blockname) {
        super(AbstractBlock.Settings.create());
        this.polymerBlock = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(Identifier.of(namespace, "block/"+blockname)));
    }

    public CustomBlock(String namespace, String blockname, Settings settings) {
        super(settings);
        this.polymerBlock = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(Identifier.of(namespace, "block/"+blockname)));
    }

    public CustomBlock(String namespace, String blockname, Settings settings, BlockModelType blockModelType) {
        super(settings);
        this.polymerBlock = PolymerBlockResourceUtils.requestBlock(blockModelType, PolymerBlockModel.of(Identifier.of(namespace, "block/"+blockname)));

    }
    /**
     * Generic method used for replacing BlockStates in case of no player context
     * It also controls some server side things like collisions
     *
     * @param state Server side/real BlockState
     * @return BlockState visible on client
     */
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return this.polymerBlock;
    }

    /**
     * Main method used for replacing BlockStates for players
     * Keep in mind you should ideally use blocks with the same hitbox as generic/non-player ones!
     *
     * @param state  Server side BlocksState
     * @param player Player viewing it
     * @return Client side BlockState
     */
    @Override
    public BlockState getPolymerBlockState(BlockState state, ServerPlayerEntity player) {
        return PolymerTexturedBlock.super.getPolymerBlockState(state, player);
    }

    /**
     * This method is called when block gets send to player
     * Allows to add client-only BlockEntities (for signs, heads, etc)
     *
     * @param blockState Real BlockState of block
     * @param pos        Position of block. Keep in mind it's mutable,
     *                   so make sure to use {@link BlockPos.Mutable#toImmutable()}
     *                   in case of using in packets, as it's reused for other positions!
     * @param player     Player packets should be send to
     */
    @Override
    public void onPolymerBlockSend(BlockState blockState, BlockPos.Mutable pos, ServerPlayerEntity player) {
        PolymerTexturedBlock.super.onPolymerBlockSend(blockState, pos, player);
    }

    /**
     * You can override this method in case of issues with light updates of this block. In most cases it's not needed.
     *
     * @param blockState
     */
    @Override
    public boolean forceLightUpdates(BlockState blockState) {
        return PolymerTexturedBlock.super.forceLightUpdates(blockState);
    }

    /**
     * Overrides breaking particle used by the block
     *
     * @param state
     * @param player
     * @return
     */
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return PolymerTexturedBlock.super.getPolymerBreakEventBlockState(state, player);
    }
}
