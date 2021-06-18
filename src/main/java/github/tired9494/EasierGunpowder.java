package github.tired9494;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class EasierGunpowder implements ModInitializer {

    public static final Block CHARCOAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).hardness(5.0F).resistance(6.0F).mapColor(MapColor.BLACK).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block CHARCOAL_BLOCK_CRACKED = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5F).resistance(4.0F).mapColor(MapColor.BLACK).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Item CRUSHED_CHARCOAL = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item MILL_CAKE = new Item(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("easier_gunpowder", "charcoal_block"), CHARCOAL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("easier_gunpowder", "charcoal_block"), new BlockItem(CHARCOAL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("easier_gunpowder", "charcoal_block_cracked"), CHARCOAL_BLOCK_CRACKED);
        Registry.register(Registry.ITEM, new Identifier("easier_gunpowder", "charcoal_block_cracked"), new BlockItem(CHARCOAL_BLOCK_CRACKED, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("easier_gunpowder", "crushed_charcoal"), CRUSHED_CHARCOAL);
        Registry.register(Registry.ITEM, new Identifier("easier_gunpowder", "mill_cake"), MILL_CAKE);

    }
}
