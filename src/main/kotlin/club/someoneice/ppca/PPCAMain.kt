package club.someoneice.ppca

import club.someoneice.ppca.init.EffectInit
import club.someoneice.ppca.init.ItemInit
import net.neoforged.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(PPCAMain.MODID)
object PPCAMain {
    const val MODID = "the_project_for_the_prevention_of_cruelty_to_animals"
    val LOGGER: Logger = LogManager.getLogger(MODID)

    init {
        EffectInit.EFFECTS.register(MOD_BUS)
        ItemInit.ITEMS.register(MOD_BUS)
        // MOD_BUS.register(Events())
    }
}
