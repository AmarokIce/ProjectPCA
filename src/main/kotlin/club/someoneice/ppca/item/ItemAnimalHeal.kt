package club.someoneice.ppca.item

import net.minecraft.entity.passive.AnimalEntity
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

abstract class ItemAnimalHeal: ItemBase(QuiltItemSettings().maxCount(16)) {
    abstract fun heal(animal: AnimalEntity)
}