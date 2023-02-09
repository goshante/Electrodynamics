package electrodynamics.common.block.subtype;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import electrodynamics.api.ISubtype;
import electrodynamics.common.item.subtype.SubtypeIngot;
import electrodynamics.common.tags.ElectrodynamicsTags;
import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public enum SubtypeResourceBlock implements ISubtype {
	tin(2.0f, 3.0f, Material.METAL, SoundType.METAL, 1, ElectrodynamicsTags.Items.STORAGE_BLOCK_TIN,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_TIN, ElectrodynamicsTags.Items.INGOT_TIN,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.tin)),
	lead(2.0f, 3.0f, Material.METAL, SoundType.METAL, 2, ElectrodynamicsTags.Items.STORAGE_BLOCK_LEAD,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_LEAD, ElectrodynamicsTags.Items.INGOT_LEAD,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.lead)),
	silver(2.0f, 3.0f, Material.METAL, SoundType.METAL, 2, ElectrodynamicsTags.Items.STORAGE_BLOCK_SILVER,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_SILVER, ElectrodynamicsTags.Items.INGOT_SILVER,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.silver)),
	bronze(2.0f, 3.0f, Material.METAL, SoundType.METAL, 1, ElectrodynamicsTags.Items.STORAGE_BLOCK_BRONZE,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_BRONZE, ElectrodynamicsTags.Items.INGOT_BRONZE,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.bronze)),
	steel(2.0f, 3.0f, Material.METAL, SoundType.METAL, 2, ElectrodynamicsTags.Items.STORAGE_BLOCK_STEEL,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_STEEL, ElectrodynamicsTags.Items.INGOT_STEEL,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.steel)),
	aluminum(2.0f, 3.0f, Material.METAL, SoundType.METAL, 2, ElectrodynamicsTags.Items.STORAGE_BLOCK_ALUMINUM,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_ALUMINUM, ElectrodynamicsTags.Items.INGOT_ALUMINUM,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.aluminum)),
	chromium(2.0f, 3.0f, Material.METAL, SoundType.METAL, 3, ElectrodynamicsTags.Items.STORAGE_BLOCK_CHROMIUM,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_CHROMIUM, ElectrodynamicsTags.Items.INGOT_CHROMIUM,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.chromium)),
	stainlesssteel(2.0f, 3.0f, Material.METAL, SoundType.METAL, 2,
			ElectrodynamicsTags.Items.STORAGE_BLOCK_STAINLESSSTEEL,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_STAINLESSSTEEL, ElectrodynamicsTags.Items.INGOT_STAINLESSSTEEL,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.stainlesssteel)),
	vanadiumsteel(2.0f, 3.0f, Material.METAL, SoundType.METAL, 2, ElectrodynamicsTags.Items.STORAGE_BLOCK_VANADIUMSTEEL,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_VANADIUMSTEEL, ElectrodynamicsTags.Items.INGOT_VANADIUMSTEEL,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.vanadiumsteel)),
	hslasteel(2.0f, 3.0f, Material.METAL, SoundType.METAL, 3, ElectrodynamicsTags.Items.STORAGE_BLOCK_HSLASTEEL,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_HSLASTEEL, ElectrodynamicsTags.Items.INGOT_HSLASTEEL,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.hslasteel)),
	titanium(2.0f, 3.0f, Material.METAL, SoundType.METAL, 3, ElectrodynamicsTags.Items.STORAGE_BLOCK_TITANIUM,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_TITANIUM, ElectrodynamicsTags.Items.INGOT_TITANIUM,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.titanium)),
	titaniumcarbide(2.0f, 3.0f, Material.METAL, SoundType.METAL, 3,
			ElectrodynamicsTags.Items.STORAGE_BLOCK_TITANIUMCARBIDE,
			ElectrodynamicsTags.Blocks.STORAGE_BLOCK_TITANIUMCARBIDE, ElectrodynamicsTags.Items.INGOT_TITANIUMCARBIDE,
			() -> ElectrodynamicsItems.getItem(SubtypeIngot.titaniumcarbide));

	private float hardness;
	private float resistance;
	private Material material;
	private SoundType soundType;
	// 0 = wood, 1 = stone, 2 = iron, 3 = diamond
	public final int miningLevel;
	public final TagKey<Item> itemTag;
	public final TagKey<Block> blockTag;
	public final TagKey<Item> sourceIngot;
	public final Supplier<Item> productIngot;

	private SubtypeResourceBlock(float hardness, float resistance, Material material, SoundType soundType,
			int miningLevel, TagKey<Item> itemTag, TagKey<Block> blockTag, TagKey<Item> sourceIngot,
			Supplier<Item> productIngot) {
		this.hardness = hardness;
		this.resistance = resistance;
		this.material = material;
		this.soundType = soundType;
		this.miningLevel = miningLevel;
		this.itemTag = itemTag;
		this.blockTag = blockTag;
		this.sourceIngot = sourceIngot;
		this.productIngot = productIngot;
	}

	public float getHardness() {
		return hardness;
	}

	public float getResistance() {
		return resistance;
	}

	public Material getMaterial() {
		return material;
	}

	public SoundType getSoundType() {
		return soundType;
	}

	@Override
	public String tag() {
		return "resourceblock" + name();
	}

	@Override
	public String forgeTag() {
		return "blocks/" + name();
	}

	@Override
	public boolean isItem() {
		return false;
	}

	public static SubtypeResourceBlock[] getForMiningLevel(int level) {
		List<SubtypeResourceBlock> values = new ArrayList<>();
		for (SubtypeResourceBlock value : values()) {
			if (value.miningLevel == level) {
				values.add(value);
			}
		}
		return values.toArray(new SubtypeResourceBlock[] {});
	}

}
