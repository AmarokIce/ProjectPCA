package club.someoneice.ppca.mixin;

import club.someoneice.ppca.EffectInit;
import club.someoneice.ppca.item.ItemAnimalHeal;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Animal.class)
public class AnimalMixin {
    @Inject(method = "mobInteract", at = @At(value = "HEAD", target = "mobInteract(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world;)Lnet/minecraft/world/InteractionResult;"), cancellable = true, remap = false)
    public void onPlayerUseOn(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {


        if (!player.getCommandSenderWorld().isClientSide() && player.getMainHandItem().getItem() instanceof ItemAnimalHeal heal) {
            Animal animal = (Animal) (Object) this;

            if (animal.getHealth() < animal.getMaxHealth()) {
                heal.heal(animal);
                if (!player.isCreative()) player.getMainHandItem().shrink(1);

                cir.setReturnValue(InteractionResult.SUCCESS);
            }
        }
    }

    @Inject(method = "hurt", at = @At(value = "RETURN", target = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"), remap = false)
    public void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Animal animal = (Animal) (Object) this;
        Random random = new Random();

        if (cir.getReturnValue()) {
            if (source == animal.damageSources().fall()) {
                if (amount > 0.4f && random.nextDouble() < 0.4d + (amount / 4)) {
                    animal.addEffect(new MobEffectInstance(EffectInit.INSTANCE.getBREAKBONE(), 20 * 60 * 10, 0));
                    animal.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 60 * 10, 2));
                }
            } else if (amount > 0.6f) {
                if (random.nextDouble() < 0.4d + (amount / 2)) {
                    animal.addEffect(new MobEffectInstance(EffectInit.INSTANCE.getBREAKBONE(), 20 * 60 * 10, 0));
                    animal.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 60 * 10, 2));
                }

                // if (random.nextDouble() < 0.35d)
            }
        }
    }
}
