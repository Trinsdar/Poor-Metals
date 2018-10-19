package trinsdar.poormetals.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trinsdar.poormetals.PoorMetals;

public class BlockPoorModdedNetherOres extends Block {
    public enum PoorModdedNetherOresVariant{
        IRON, GOLD, COPPER, TIN, SILVER, LEAD, NICKEL, ZINC, MERCURY, PLATINUM, BISMUTH, ANTIMONY;
    }

    PoorModdedNetherOresVariant variant;
    public BlockPoorModdedNetherOres(PoorModdedNetherOresVariant variant) {
        super(Material.ROCK);
        this.variant = variant;
        final String name = "poor_nether_"+ variant.toString().toLowerCase()+ "_ore";
        setUnlocalizedName( PoorMetals.MODID + ".block." + name );
        setRegistryName(name);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(getRegistryName(), "inventory")
        );
    }
}