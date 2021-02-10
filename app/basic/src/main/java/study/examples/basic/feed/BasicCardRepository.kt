package study.examples.basic.feed

import android.view.ViewGroup
import study.examples.component.feed.BaseCardItem
import study.examples.component.feed.BaseCardRepository
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.basic.feed.card.BasicCardV1

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */

class BasicCardRepository<VH : BaseCardVH<T>, T : BaseCardItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            BASIC_CARD_V1 -> BasicCardV1.createView(parent)
            else -> EmptyCard.createView(parent)
        } as VH
    }
}