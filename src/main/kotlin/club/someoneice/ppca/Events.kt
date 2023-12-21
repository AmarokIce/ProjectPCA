package club.someoneice.ppca

import club.someoneice.ppca.init.EffectInit
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.animal.Animal
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod.EventBusSubscriber
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent
import java.util.Random

@EventBusSubscriber(modid = PPCAMain.MODID)
class Events {
    @SubscribeEvent
    fun onLivingHurtEvent(event: LivingHurtEvent) {
        val animal = if (event.entity is Animal) event.entity else return
        val source = event.source
        val amount = event.amount
        val random = Random()
        if (source == animal.damageSources().fall()) {
            if (amount > 0.4f && random.nextDouble() < 0.4 + amount / 4) {
                animal.addEffect(MobEffectInstance(EffectInit.BREAKON_BONE, 20 * 60 * 10, 0))
            }
        } else if (amount > 0.6f) {
            if (random.nextDouble() < 0.4 + amount / 2) {
                animal.addEffect(MobEffectInstance(EffectInit.BREAKON_BONE, 20 * 60 * 10, 0))
            }
        }
    }
}