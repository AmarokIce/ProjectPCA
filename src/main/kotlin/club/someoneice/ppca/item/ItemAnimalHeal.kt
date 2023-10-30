package club.someoneice.ppca.item

import net.minecraft.world.entity.animal.Animal

abstract class ItemAnimalHeal: ItemBase(Properties().stacksTo(16)) {
    abstract fun heal(animal: Animal)
}