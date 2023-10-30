package club.someoneice.ppca

object PPCAMain {
    const val MODID: String = "the_project_for_the_prevention_of_cruelty_to_animals"
    const val VERSION: String = "0.0.1"
}

public fun init() {
    ItemInit.ITEMS.registryAll()
    EffectInit.EFFECTS.registryAll()
    TabInit.TABS.registryAll()
}