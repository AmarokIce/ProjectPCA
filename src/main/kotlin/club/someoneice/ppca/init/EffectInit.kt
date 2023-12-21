package club.someoneice.ppca.init

import club.someoneice.ppca.PPCAMain
import club.someoneice.ppca.effect.EffectBreakonBone
import net.minecraft.core.registries.Registries
import net.neoforged.neoforge.registries.DeferredRegister

import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object EffectInit {
    val EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, PPCAMain.MODID)

    val BREAKON_BONE by EFFECTS.register("breakon_bone") { -> EffectBreakonBone() }
}
