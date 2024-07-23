package xyz.merith.oven.Blocks.Templates;

import eu.pb4.factorytools.api.item.AutoModeledPolymerItem;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class SolidBlock extends Block implements AutoModeledPolymerItem {
    private final Item polymerItem;

    public SolidBlock(Settings settings) {
        super(settings);
        this.polymerItem = BaseItemProvider.requestItem();
    }

    @Override
    public Item getPolymerItem() {
        return this.polymerItem;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.getPolymerItem(itemStack, player);
    }

    /**
     * Method used for creation of client-side ItemStack
     *
     * @param itemStack   Server-side ItemStack
     * @param tooltipType
     * @param lookup
     * @param player      Player for which it's send
     * @return Client-side ItemStack
     */
    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, TooltipType tooltipType, RegistryWrapper.WrapperLookup lookup, @Nullable ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.getPolymerItemStack(itemStack, tooltipType, lookup, player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.getPolymerCustomModelData(itemStack, player);
    }

    /**
     * Method used for getting custom armor color of items
     * It's designed to be used alongside {@link PolymerResourcePackUtils#requestArmor(Identifier)}
     * Make sure colors isn't even so it won't get wrong texture
     *
     * @param itemStack Server-side ItemStack
     * @param player    Player for which it's send
     * @return Custom color or -1 if not present
     */
    @Override
    public int getPolymerArmorColor(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.getPolymerArmorColor(itemStack, player);
    }

    /**
     * This method allows to modify tooltip text
     * If you just want to add your own one, use {@link Item#appendTooltip(ItemStack, Item.TooltipContext, List, TooltipType)}
     *
     * @param tooltip Current tooltip text
     * @param stack   Server-side ItemStack
     * @param player  Target player
     */
    @Override
    public void modifyClientTooltip(List<Text> tooltip, ItemStack stack, @Nullable ServerPlayerEntity player) {
        AutoModeledPolymerItem.super.modifyClientTooltip(tooltip, stack, player);
    }

    @Override
    public Item getPolymerReplacement(ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.getPolymerReplacement(player);
    }

    /**
     * Allows to gate syncing of this object with clients running polymer
     *
     * @param player
     */
    @Override
    public boolean canSynchronizeToPolymerClient(ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.canSynchronizeToPolymerClient(player);
    }

    /**
     * Allows to mark it to still send it to supported clients (for client optional setups)
     * Currently used for tags
     *
     * @param player
     */
    @Override
    public boolean canSyncRawToClient(ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.canSyncRawToClient(player);
    }

    @Override
    public boolean handleMiningOnServer(ItemStack tool, BlockState targetBlock, BlockPos pos, ServerPlayerEntity player) {
        return AutoModeledPolymerItem.super.handleMiningOnServer(tool, targetBlock, pos, player);
    }

    @Override
    public boolean shouldStorePolymerItemStackCount() {
        return AutoModeledPolymerItem.super.shouldStorePolymerItemStackCount();
    }

    @Override
    public int getPolymerCustomModelData() {
        return AutoModeledPolymerItem.super.getPolymerCustomModelData();
    }

    @Override
    public void onRegistered(Identifier selfId) {
        AutoModeledPolymerItem.super.onRegistered(selfId);
    }

    /**
     * Return the current appearance of the block, i.e. which block state this block reports to look like on a given side.
     *
     * <p>Common implementors are covers and facades, or any other mimic blocks that proxy another block's model.
     * These will want to override this method. In that case, make sure to carefully read the implementation guidelines below.
     *
     * <p>Common consumers are models with connected textures that wish to seamlessly connect to mimic blocks.
     * These will want to check the apparent block state using {@link FabricBlockState#getAppearance}.
     *
     * <p>Generally, the appearance will be queried from a nearby block,
     * identified by the optional {@code sourcePos} and {@code sourceState} parameters.
     *
     * <p>When a block changes appearance, it should trigger a chunk remesh for itself and the adjacent blocks,
     * for example by calling {@link World#updateListeners}.
     *
     * <p>Note: Overriding this method for a block does <strong>not</strong> change how it renders.
     * It's up to modded models to check for the appearance of nearby blocks and adjust accordingly.
     *
     * <h3>Implementation guidelines</h3>
     *
     * <p>This can be called on the server, where block entity data can be safely accessed,
     * and on the client, possibly in a meshing thread, where block entity data is not safe to access!
     * Here is an example of how data from a block entity can be handled safely.
     * The block entity should override {@code RenderDataBlockEntity#getBlockEntityRenderData} to return
     * the necessary data. Refer to the documentation of {@code RenderDataBlockEntity} for more information.
     * <pre>{@code @Override
     * public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
     *     if (renderView instanceof ServerWorld serverWorld) {
     *         // Server side; ok to use block entity directly!
     *         BlockEntity blockEntity = serverWorld.getBlockEntity(pos);
     *
     *         if (blockEntity instanceof ...) {
     *             // Get data from block entity
     *             return ...;
     *         }
     *     } else {
     *         // Client side; need to use the block entity render data!
     *         Object data = renderView.getBlockEntityRenderData(pos);
     *
     *         // Check if data is not null and of the correct type, and use that to determine the appearance
     *         if (data instanceof ...) {
     *             // get appearance for side ...
     *             return ...;
     *         }
     *     }
     *
     *     // Example of varying the appearance based on the source pos
     *     if (sourcePos != null) {
     *         // get appearance for side ...
     *         return ...;
     *     }
     *
     *     // If there is no other appearance, just return the original block state
     *     return state;
     * });
     * }</pre>
     *
     * @param state       state of this block, whose appearance is being queried
     * @param renderView  the world this block is in
     * @param pos         position of this block, whose appearance is being queried
     * @param side        the side for which the appearance is being queried
     * @param sourceState (optional) state of the block that is querying the appearance, or null if unknown
     * @param sourcePos   (optional) position of the block that is querying the appearance, or null if unknown
     * @return the appearance of the block on the given side; the original {@code state} can be returned if there is no better option
     */
    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return super.isEnabled(enabledFeatures);
    }
}
