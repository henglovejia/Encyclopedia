package study.examples.advance.feed

import android.view.ViewGroup
import com.examples.feed.repository.BaseCardRepository
import study.examples.advance.feed.card.AdvanceCardV1
import study.examples.advance.feed.card.BaseAdvanceCard
import study.examples.advance.feed.item.BaseAdvanceItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class AdvanceCardRepository<VH : BaseAdvanceCard<T>, T : BaseAdvanceItem> :
    BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            ADVANCE_CARD_V1 -> AdvanceCardV1.createView(parent)
            else -> AdvanceCardV1.createView(parent)
        } as VH
    }
}