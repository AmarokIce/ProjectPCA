package club.someoneice.ppca

import club.someoneice.pc.registry.GroupManager
import club.someoneice.pc.registry.GroupObject
import club.someoneice.pc.util.asItemStack
import net.minecraft.world.item.Items

object TabInit {
    val TABS: GroupManager = GroupManager(PPCAMain.MODID)

    val PPCATab: GroupObject = TABS.registry("ppca_tab", Items.BONE.asItemStack())
}