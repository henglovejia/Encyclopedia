package study.examples.debug.feed

import android.view.ViewGroup
import com.examples.feed.repository.BaseCardRepository
import study.examples.debug.feed.card.BaseDebugCard
import study.examples.debug.feed.card.DebugCardV1
import study.examples.debug.feed.item.BaseDebugItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class DebugCardRepository<VH : BaseDebugCard<T>, T : BaseDebugItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            DEBUG_CARD_V1 -> DebugCardV1.createView(parent)
            else -> DebugCardV1.createView(parent)
        } as VH
    }
}