package club.someoneice.ppca.mixin;

import club.someoneice.ppca.EffectInit;
import club.someoneice.ppca.item.ItemAnimalHeal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(AnimalEntity.class)
public class AnimalMixin {
    @Inject(method = "interactMob", at = @At(value = "HEAD", target = "interactMob(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;"), cancellable = true, remap = false)
    public void onPlayerUseOn(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (!player.getCommandSenderWorld().isClient() && player.getMainHandStack().getItem() instanceof ItemAnimalHeal heal) {
            AnimalEntity animal = (AnimalEntity) (Object) this;

            if (animal.getHealth() < animal.getMaxHealth()) {
                heal.heal(animal);
                if (!player.isCreative()) player.getMainHandStack().decrement(1);

                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }

    @Inject(method = "damage", at = @At(value = "RETURN", target = "hurt(Lnet/minecraft/entity/damage/DamageSource;F)Z"), remap = false)
    public void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        AnimalEntity animal = (AnimalEntity) (Object) this;
        Random random = new Random();

        if (cir.getReturnValue()) {
            if (source == animal.getDamageSources().fall()) {
                if (amount > 0.4f && random.nextDouble() < 0.4d + (amount / 4)) {
                    animal.addStatusEffect(new StatusEffectInstance(EffectInit.INSTANCE.getBREAKBONE(), 20 * 60 * 10, 0));
                    animal.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 60 * 10, 2));
                }
            } else if (amount > 0.6f) {
                if (random.nextDouble() < 0.4d + (amount / 2)) {
                    animal.addStatusEffect(new StatusEffectInstance(EffectInit.INSTANCE.getBREAKBONE(), 20 * 60 * 10, 0));
                    animal.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 60 * 10, 2));
                }

                // if (random.nextDouble() < 0.35d)
            }
        }
    }
}
