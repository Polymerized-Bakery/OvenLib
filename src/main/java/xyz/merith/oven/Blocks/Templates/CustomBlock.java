package xyz.merith.oven.Blocks.Templates;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CustomBlock extends Block implements PolymerBlock {
    private final PolymerModelData model;
    private static final IntProperty TEST = IntProperty.of("test", 0, 100);
    private Block BlockPropertyTemplate;

    /**
     * Constructs a new CustomBlock with the specified properties and Polymer model data.
     *
     * @param namespace the namespace (usually the mod ID) for the model identifier
     * @param blockName the name of the block, used for generating the model identifier
     */
    public CustomBlock(String namespace, String blockName) {
        super(AbstractBlock.Settings.copy(Blocks.STONE));
        this.BlockPropertyTemplate = Blocks.STONE;
        this.model = PolymerResourcePackUtils.requestModel(BlockPropertyTemplate.asItem(), Identifier.of(namespace, blockName));
    }
    /**
     * Constructs a new CustomBlock with the specified properties and Polymer model data.
     *
     * @param namespace the namespace (usually the mod ID) for the model identifier
     * @param blockName the name of the block, used for generating the model identifier
     * @param settings  the block settings
     */
    public CustomBlock(String namespace, String blockName, Settings settings) {
        super(settings);
        this.BlockPropertyTemplate = Blocks.STONE;
        this.model = PolymerResourcePackUtils.requestModel(BlockPropertyTemplate.asItem(), Identifier.of(namespace, blockName));
    }

    /**
     * Constructs a new CustomBlock with the specified properties and Polymer model data.
     *
     * @param namespace the namespace (usually the mod ID) for the model identifier
     * @param blockName the name of the block, used for generating the model identifier
     * @param settings  the block settings
     * @param baseBlock the block to use as the base for the Polymer model
     */
    public CustomBlock(String namespace, String blockName, Settings settings, Block baseBlock) {
        super(settings);
        this.BlockPropertyTemplate = baseBlock;
        this.model = PolymerResourcePackUtils.requestModel(BlockPropertyTemplate.asItem(), Identifier.of(namespace, blockName));

    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(TEST);
    }

    /**
     * Gets the Polymer block state for rendering.
     *
     * @param state the current block state
     * @return the Polymer block state
     */
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return BlockPropertyTemplate.getDefaultState();
    }

    /**
     * Gets the Polymer block state for the break event.
     *
     * @param state  the current block state
     * @param player the player breaking the block
     * @return the Polymer block state for the break event
     */
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return BlockPropertyTemplate.getDefaultState();
    }
}
