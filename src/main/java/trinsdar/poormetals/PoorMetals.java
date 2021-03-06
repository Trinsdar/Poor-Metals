package trinsdar.poormetals;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import trinsdar.poormetals.init.ModBlocks;
import trinsdar.poormetals.proxy.CommonProxy;

import java.io.File;

@Mod(modid = PoorMetals.MODID, name = PoorMetals.MODNAME, version = PoorMetals.VERSION, dependencies = PoorMetals.DEPENDENCIES)
public class PoorMetals {
    public static final String MODID = "poormetals";
    public static final String MODNAME = "Poor Metals";
    public static final String VERSION= "@VERSION@";
    public static final String DEPENDENCIES = "after:basemetals; after:modernmetals";
    public static final CreativeTabs creativeTab = new CreativeTabPoorMetals(MODID);

    @SidedProxy(clientSide = "trinsdar.poormetals.proxy.ClientProxy", serverSide = "trinsdar.poormetals.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static PoorMetals instance;

    public static Logger logger;

    public PoorMetals(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
        PoorMetalsRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(MODID))
        {
            ConfigManager.sync(MODID, Config.Type.INSTANCE);
        }
    }
}
