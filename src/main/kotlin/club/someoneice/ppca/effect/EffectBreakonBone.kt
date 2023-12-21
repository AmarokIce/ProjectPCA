package club.someoneice.ppca.effect

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import java.awt.Color

class EffectBreakonBone: MobEffect(MobEffectCategory.HARMFUL, Color.GRAY.rgb) {
    override fun shouldApplyEffectTickThisTick(time: Int, lv: Int): Boolean = true

    override fun applyEffectTick(entity: LivingEntity, lv: Int) {
        entity.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 10, (lv + 1) * 2))
    }
}