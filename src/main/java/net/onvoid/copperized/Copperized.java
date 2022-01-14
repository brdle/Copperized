package net.onvoid.copperized;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.onvoid.copperized.proxy.CommonProxy;
import net.onvoid.copperized.proxy.ClientProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("copperized")
public class Copperized {
    public static final String MODID = "copperized";
    public static Copperized instance;
    public static CommonProxy proxy;
    private static final Logger LOGGER = LogManager.getLogger();

    public Copperized() {
        instance = this;

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        proxy.start();
    }
}
