package club.someoneice.ppca

import club.someoneice.pc.registry.RegistryManager
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import java.awt.Color

object EffectInit {
    val EFFECTS: RegistryManager<MobEffect> = RegistryManager(PPCAMain.MODID, BuiltInRegistries.MOB_EFFECT)

    val BREAKBONE by EFFECTS.registry("break_bone", BreakBone())

    class BreakBone: MobEffect(MobEffectCategory.HARMFUL, Color.GRAY.rgb)

}