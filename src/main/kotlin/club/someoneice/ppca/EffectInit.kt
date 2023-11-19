package club.someoneice.ppca

import club.someoneice.pc.registry.RegistryManager
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType
import net.minecraft.registry.Registries
import java.awt.Color

object EffectInit {
    val EFFECTS: RegistryManager<StatusEffect> = RegistryManager(PPCAMain.MODID, Registries.STATUS_EFFECT)

    val BREAKBONE by EFFECTS.registry("break_bone", BreakBone())

    class BreakBone: StatusEffect(StatusEffectType.HARMFUL, Color.GRAY.rgb)

}