package club.someoneice.ppca

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object PPCAMain: ModInitializer {
    const val MODID: String = "the_project_for_the_prevention_of_cruelty_to_animals"
    const val VERSION: String = "0.0.1"

    override fun onInitialize(mod: ModContainer?) {
        ItemInit.ITEMS.registryAll()
        EffectInit.EFFECTS.registryAll()
        TabInit.TABS.registryAll()
    }
}