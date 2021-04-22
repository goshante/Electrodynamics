package electrodynamics.common.block.connect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import electrodynamics.DeferredRegisters;
import electrodynamics.api.network.conductor.IConductor;
import electrodynamics.common.block.subtype.SubtypeWire;
import electrodynamics.common.network.ElectricityUtilities;
import electrodynamics.common.tile.network.TileLogisticalWire;
import electrodynamics.common.tile.network.TileWire;
import electrodynamics.prefab.utilities.UtilitiesElectricity;
import electrodynamics.prefab.utilities.object.TransferPack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockWire extends Block {
    public static final Map<Direction, EnumProperty<EnumConnectType>> FACING_TO_PROPERTY_MAP = Util.make(Maps.newEnumMap(Direction.class), p -> {
	p.put(Direction.NORTH, EnumConnectType.NORTH);
	p.put(Direction.EAST, EnumConnectType.EAST);
	p.put(Direction.SOUTH, EnumConnectType.SOUTH);
	p.put(Direction.WEST, EnumConnectType.WEST);
	p.put(Direction.UP, EnumConnectType.UP);
	p.put(Direction.DOWN, EnumConnectType.DOWN);
    });

    public static final HashSet<Block> WIRESET = new HashSet<>();

    protected final VoxelShape cube;
    protected final VoxelShape cubeup;
    protected final VoxelShape cubedown;
    protected final VoxelShape cubenorth;
    protected final VoxelShape cubesouth;
    protected final VoxelShape cubewest;
    protected final VoxelShape cubeeast;

    protected HashMap<HashSet<Direction>, VoxelShape> shapestates = new HashMap<>();
    protected boolean locked = false;

    public final SubtypeWire wire;

    public BlockWire(SubtypeWire wire) {
	super(Properties.create(wire.insulated ? Material.WOOL : Material.IRON).sound(wire.insulated ? SoundType.CLOTH : SoundType.METAL)
		.hardnessAndResistance(0.15f).variableOpacity());
	this.wire = wire;
	double w = wire.insulated ? 2 : 1;
	double sm = 8 - w;
	double lg = 8 + w;
	cube = Block.makeCuboidShape(sm, sm, sm, lg, lg, lg);
	cubeup = Block.makeCuboidShape(sm, sm, sm, lg, 16, lg);
	cubedown = Block.makeCuboidShape(sm, 0, sm, lg, lg, lg);
	cubenorth = Block.makeCuboidShape(sm, sm, 0, lg, lg, lg);
	cubesouth = Block.makeCuboidShape(sm, sm, sm, lg, lg, 16);
	cubewest = Block.makeCuboidShape(0, sm, sm, lg, lg, lg);
	cubeeast = Block.makeCuboidShape(sm, sm, sm, 16, lg, lg);
	WIRESET.add(this);
	setDefaultState(stateContainer.getBaseState().with(BlockStateProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
	FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
	return super.getStateForPlacement(context).with(BlockStateProperties.WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
    }

    @Override
    @Deprecated
    public FluidState getFluidState(BlockState state) {
	return state.get(BlockStateProperties.WATERLOGGED) == Boolean.TRUE ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    @Deprecated
    public List<ItemStack> getDrops(BlockState state, Builder builder) {
	return Arrays.asList(new ItemStack(DeferredRegisters.SUBTYPEITEM_MAPPINGS.get(wire)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	super.fillStateContainer(builder);
	builder.add(EnumConnectType.UP, EnumConnectType.DOWN, EnumConnectType.NORTH, EnumConnectType.EAST, EnumConnectType.SOUTH,
		EnumConnectType.WEST);
	builder.add(BlockStateProperties.WATERLOGGED);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
	return true;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	VoxelShape shape = cube;
	HashSet<Direction> checked = new HashSet<>();
	if (!state.get(EnumConnectType.UP).equals(EnumConnectType.NONE)) {
	    checked.add(Direction.UP);
	}
	if (!state.get(EnumConnectType.DOWN).equals(EnumConnectType.NONE)) {
	    checked.add(Direction.DOWN);
	}
	if (!state.get(EnumConnectType.WEST).equals(EnumConnectType.NONE)) {
	    checked.add(Direction.WEST);
	}
	if (!state.get(EnumConnectType.EAST).equals(EnumConnectType.NONE)) {
	    checked.add(Direction.EAST);
	}
	if (!state.get(EnumConnectType.NORTH).equals(EnumConnectType.NONE)) {
	    checked.add(Direction.NORTH);
	}
	if (!state.get(EnumConnectType.SOUTH).equals(EnumConnectType.NONE)) {
	    checked.add(Direction.SOUTH);
	}
	locked = true;
	if (shapestates.containsKey(checked)) {
	    locked = false;
	    return shapestates.get(checked);
	}
	locked = false;
	for (Direction dir : checked) {
	    switch (dir) {
	    case DOWN:
		shape = VoxelShapes.combineAndSimplify(shape, cubedown, IBooleanFunction.OR);
		break;
	    case EAST:
		shape = VoxelShapes.combineAndSimplify(shape, cubeeast, IBooleanFunction.OR);
		break;
	    case NORTH:
		shape = VoxelShapes.combineAndSimplify(shape, cubenorth, IBooleanFunction.OR);
		break;
	    case SOUTH:
		shape = VoxelShapes.combineAndSimplify(shape, cubesouth, IBooleanFunction.OR);
		break;
	    case UP:
		shape = VoxelShapes.combineAndSimplify(shape, cubeup, IBooleanFunction.OR);
		break;
	    case WEST:
		shape = VoxelShapes.combineAndSimplify(shape, cubewest, IBooleanFunction.OR);
		break;
	    default:
		break;
	    }
	}
	while (locked) {
	    System.out.println("Wire bounding boxes locked. This should never happen!");
	}
	shapestates.put(checked, shape);
	if (shape == null) {
	    return VoxelShapes.empty();
	}
	return shape;
    }

    @Override
    @Deprecated
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
	TileWire tile = (TileWire) worldIn.getTileEntity(pos);
	if (tile != null && tile.getNetwork() != null && tile.getNetwork().getActiveTransmitted() > 0) {
	    if (tile.getNetwork().getActiveVoltage() <= 240.0 && wire.insulated || wire.ceramic && tile.getNetwork().getActiveVoltage() <= 480.0) {
		UtilitiesElectricity.electrecuteEntity(entityIn,
			TransferPack.joulesVoltage(tile.getNetwork().getActiveTransmitted(), tile.getNetwork().getActiveVoltage()));
	    }
	}
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState stateIn, @Nullable LivingEntity placer, ItemStack stack) {
	BlockState acc = stateIn;
	for (Direction d : Direction.values()) {
	    TileEntity facingTile = worldIn.getTileEntity(pos.offset(d));
	    if (ElectricityUtilities.isConductor(facingTile)) {
		acc = acc.with(FACING_TO_PROPERTY_MAP.get(d), EnumConnectType.WIRE);
	    } else if (ElectricityUtilities.isElectricReceiver(facingTile, d.getOpposite())) {
		acc = acc.with(FACING_TO_PROPERTY_MAP.get(d), EnumConnectType.INVENTORY);
	    }
	}
	worldIn.setBlockState(pos, acc);
    }

    @Override
    @Deprecated
    public boolean canProvidePower(BlockState state) {
	return ((BlockWire) state.getBlock()).wire.logistical;
    }

    @Override
    @Deprecated
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
	return blockState.getWeakPower(blockAccess, pos, side);
    }

    @Override
    @Deprecated
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
	TileEntity tile = blockAccess.getTileEntity(pos);
	if (tile instanceof TileLogisticalWire) {
	    return ((TileLogisticalWire) tile).isPowered ? 15 : 0;
	}
	return 0;
    }

    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
	    BlockPos facingPos) {
	if (stateIn.get(BlockStateProperties.WATERLOGGED) == Boolean.TRUE) {
	    world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
	}
	EnumProperty<EnumConnectType> property = FACING_TO_PROPERTY_MAP.get(facing);
	TileEntity tile = world.getTileEntity(facingPos);
	if (tile instanceof IConductor) {
	    return stateIn.with(property, EnumConnectType.WIRE);
	} else if (ElectricityUtilities.isElectricReceiver(tile, facing.getOpposite())) {
	    return stateIn.with(property, EnumConnectType.INVENTORY);
	} else {
	    return stateIn.with(property, EnumConnectType.NONE);
	}
    }

    @Deprecated
    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
	super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
	if (!worldIn.isRemote) {
	    TileEntity tile = worldIn.getTileEntity(pos);
	    if (tile instanceof IConductor) {
		((IConductor) tile).refreshNetwork();
	    }
	}
    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
	super.onNeighborChange(state, world, pos, neighbor);
	if (!world.isRemote()) {
	    TileEntity tile = world.getTileEntity(pos);
	    if (tile instanceof IConductor) {
		((IConductor) tile).refreshNetworkIfChange();
	    }
	}
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
	return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	return ((BlockWire) state.getBlock()).wire.logistical ? new TileLogisticalWire() : new TileWire();
    }
}
