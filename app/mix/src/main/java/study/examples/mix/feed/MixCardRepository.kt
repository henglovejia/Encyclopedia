package study.examples.mix.feed

import android.view.ViewGroup
import study.examples.component.feed.BaseCardItem
import study.examples.component.feed.BaseCardRepository
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.mix.feed.card.MixCardV1

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */

class MixCardRepository<VH : BaseCardVH<T>, T : BaseCardItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            MIX_CARD_V1 -> MixCardV1.createView(parent)
            else -> EmptyCard.createView(parent)
        } as VH
    }
}