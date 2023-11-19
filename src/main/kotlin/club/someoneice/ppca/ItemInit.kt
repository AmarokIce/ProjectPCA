package club.someoneice.ppca

import club.someoneice.pc.registry.RegistryManager
import club.someoneice.pc.util.instance
import club.someoneice.ppca.item.ItemAnimalHeal
import club.someoneice.ppca.item.ItemBase
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.item.Item
import net.minecraft.registry.Registries

object ItemInit {
    val ITEMS: RegistryManager<Item> = RegistryManager(PPCAMain.MODID, Registries.ITEM)

    // val FABRIC by ITEMS.registry("fabric", ItemBase());
    val BRINE   by ITEMS.registry("brine", ItemBase())

    val BANDAGE by ITEMS.registry("bandage", ItemBandage())
    val SPLIT   by ITEMS.registry("split", ItemSplit())
    val PLASTER by ITEMS.registry("plaster", ItemPlaster())
    val HERBAL  by ITEMS.registry("herbal", ItemHerbal())
    val HERBAL_BANDAGE by ITEMS.registry("herbal_bandage", ItemHerbalBandage())
    val AID_KIT by ITEMS.registry("first_aid_kit", ItemFirstAidKit())

    class ItemBandage: ItemAnimalHeal() {
        override fun heal(animal: AnimalEntity) {
            animal.heal(3.0f)
            animal.addStatusEffect(StatusEffects.SLOWNESS.instance(20 * 10, 0))
        }
    }

    class ItemSplit: ItemAnimalHeal() {
        override fun heal(animal: AnimalEntity) {
            animal.heal(1.6f)
            animal.addStatusEffect(StatusEffects.SLOWNESS.instance(20 * 60 * 2, 2))
            animal.removeStatusEffect(EffectInit.BREAKBONE)
        }
    }

    class ItemPlaster: ItemAnimalHeal() {
        override fun heal(animal: AnimalEntity) {
            animal.heal(6.0f)
            animal.addStatusEffect(StatusEffects.SLOWNESS.instance(20 * 60, 2))
            animal.removeStatusEffect(EffectInit.BREAKBONE)
        }
    }

    class ItemHerbal: ItemAnimalHeal() {
        override fun heal(animal: AnimalEntity) {
            animal.addStatusEffect(StatusEffects.REGENERATION.instance(20 * 10, 0))
        }
    }

    class ItemHerbalBandage: ItemAnimalHeal() {
        override fun heal(animal: AnimalEntity) {
            animal.heal(6.0f)
            animal.addStatusEffect(StatusEffects.REGENERATION.instance(20 * 30, 0))
        }
    }

    class ItemFirstAidKit: ItemAnimalHeal() {
        override fun heal(animal: AnimalEntity) {
            animal.heal(12.5f)
            animal.addStatusEffect(StatusEffects.REGENERATION.instance(20 * 60, 1))
            animal.removeStatusEffect(EffectInit.BREAKBONE)
        }
    }
}
