package study.examples.debug.feed

import android.view.ViewGroup
import study.examples.component.feed.BaseCardItem
import study.examples.component.feed.BaseCardRepository
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.debug.feed.card.DebugCardV1Holder

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class DebugCardRepository<VH : BaseCardVH<ITEM>, ITEM : BaseCardItem> : BaseCardRepository<VH, ITEM>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            DEBUG_CARD_V1 -> DebugCardV1Holder.createView(parent)
            else -> EmptyCard.createView(parent)
        } as VH
    }
}