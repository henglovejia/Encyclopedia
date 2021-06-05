package study.examples.mix.feed

import android.view.ViewGroup
import com.examples.feed.repository.BaseCardRepository
import study.examples.mix.feed.card.BaseMixCard
import study.examples.mix.feed.card.MixCardV1
import study.examples.mix.feed.item.BaseMixItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class MixCardRepository<VH : BaseMixCard<T>, T : BaseMixItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {
            MIX_CARD_V1 -> MixCardV1.createView(parent)
            else -> MixCardV1.createView(parent)
        } as VH
    }
}