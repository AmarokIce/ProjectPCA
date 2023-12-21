package club.someoneice.ppca.item

import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.animal.Animal
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

abstract class ItemAnimalHeal: Item(Properties().stacksTo(16)) {
    abstract fun heal(animal: Animal)

    override fun onLeftClickEntity(stack: ItemStack?, player: Player?, entity: Entity?): Boolean {
        if (entity is Animal) {
            heal(entity)
            return false;
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}