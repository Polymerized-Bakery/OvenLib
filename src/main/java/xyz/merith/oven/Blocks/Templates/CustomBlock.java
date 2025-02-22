package xyz.merith.oven.Blocks.Templates;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

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
     * Main method used for replacing BlockStates for players
     * Keep in mind you should ideally use blocks with the same hitbox as generic/non-player ones!
     *
     * @param state   Server side BlocksState
     * @param context PacketContext this method is called with, might be empty!
     * @return Client side BlockState
     */
    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return this.polymerBlock;
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
}
