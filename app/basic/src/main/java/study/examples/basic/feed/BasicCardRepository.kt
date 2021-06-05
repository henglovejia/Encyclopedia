package study.examples.basic.feed

import android.view.ViewGroup
import com.examples.feed.repository.BaseCardRepository
import study.examples.basic.feed.card.BaseBasicCard
import study.examples.basic.feed.card.BasicCardV1
import study.examples.basic.feed.item.BaseBasicItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class BasicCardRepository<VH : BaseBasicCard<T>, T : BaseBasicItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            BASIC_CARD_V1 -> BasicCardV1.createView(parent)
            else -> BasicCardV1.createView(parent)
        } as VH
    }
}