package study.examples.advance.feed

import android.view.ViewGroup
import study.examples.component.feed.BaseCardItem
import study.examples.component.feed.BaseCardRepository
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.advance.feed.card.AdvanceCardV1

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class AdvanceCardRepository<VH : BaseCardVH<T>, T : BaseCardItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            ADVANCE_CARD_V1 -> AdvanceCardV1.createView(parent)
            else -> EmptyCard.createView(parent)
        } as VH
    }
}