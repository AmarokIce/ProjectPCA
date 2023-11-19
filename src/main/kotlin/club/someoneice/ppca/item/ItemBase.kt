package club.someoneice.ppca.item

import club.someoneice.pc.util.setTab
import club.someoneice.ppca.TabInit
import net.minecraft.item.Item
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

open class ItemBase(properties: QuiltItemSettings = QuiltItemSettings()): Item(properties) {
    init {
        this.setTab(TabInit.PPCATab)
    }
}