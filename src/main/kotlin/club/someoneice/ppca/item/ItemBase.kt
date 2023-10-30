package club.someoneice.ppca.item

import club.someoneice.pc.util.setTab
import club.someoneice.ppca.TabInit
import net.minecraft.world.item.Item

open class ItemBase(properties: Properties = Properties()): Item(properties) {
    init {
        this.setTab(TabInit.PPCATab)
    }
}