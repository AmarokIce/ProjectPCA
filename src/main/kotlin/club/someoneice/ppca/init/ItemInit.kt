package club.someoneice.ppca.init

import club.someoneice.ppca.PPCAMain
import club.someoneice.ppca.item.ItemAnimalHeal
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.animal.Animal
import net.neoforged.neoforge.registries.DeferredRegister

import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ItemInit {
    val ITEMS = DeferredRegister.createItems(PPCAMain.MODID)

    val BANDAGE by ITEMS.register("bandage") { ->
        ItemBandage()
    }
    val SPLIT   by ITEMS.register("split") { ->
        ItemSplit()
    }
    val PLASTER by ITEMS.register("plaster") { ->
        ItemPlaster()
    }
    val HERBAL  by ITEMS.register("herbal") { ->
        ItemHerbal()
    }
    val HERBAL_BANDAGE by ITEMS.register("herbal_bandage") { ->
        ItemHerbalBandage()
    }
    val AID_KIT by ITEMS.register("first_aid_kit") { ->
        ItemFirstAidKit()
    }

    class ItemBandage: ItemAnimalHeal() {
        override fun heal(animal: Animal) {
            animal.heal(3.0f)
            animal.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 10, 0))
        }
    }

    class ItemSplit: ItemAnimalHeal() {
        override fun heal(animal: Animal) {
            animal.heal(1.6f)
            animal.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 60 * 2, 2))
            animal.removeEffect(EffectInit.BREAKON_BONE)
        }
    }

    class ItemPlaster: ItemAnimalHeal() {
        override fun heal(animal: Animal) {
            animal.heal(6.0f)
            animal.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 60, 2))
            animal.removeEffect(EffectInit.BREAKON_BONE)
        }
    }

    class ItemHerbal: ItemAnimalHeal() {
        override fun heal(animal: Animal) {
            animal.addEffect(MobEffectInstance(MobEffects.REGENERATION, 20 * 10, 0))
        }
    }

    class ItemHerbalBandage: ItemAnimalHeal() {
        override fun heal(animal: Animal) {
            animal.heal(6.0f)
            animal.addEffect(MobEffectInstance(MobEffects.REGENERATION, 20 * 30, 0))
        }
    }

    class ItemFirstAidKit: ItemAnimalHeal() {
        override fun heal(animal: Animal) {
            animal.heal(12.5f)
            animal.addEffect(MobEffectInstance(MobEffects.REGENERATION, 20 * 60, 1))
            animal.removeEffect(EffectInit.BREAKON_BONE)
        }
    }
}