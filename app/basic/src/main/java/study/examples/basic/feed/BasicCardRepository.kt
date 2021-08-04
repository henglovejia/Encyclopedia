package study.examples.basic.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import com.examples.feed.repository.BaseCardRepository
import study.examples.basic.feed.card.BaseBasicCard
import study.examples.basic.feed.card.BasicCardV1
import study.examples.basic.model.card.BaseBasicItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class BasicCardRepository<VH : BaseBasicCard<T>, T : BaseBasicItem> : BaseCardRepository<VH, T>() {
    override fun realCreate(parent: ViewGroup, viewType: Int): VH {
        return viewType.mapViewType2Enum()?.run {
            when (this) {
                BasicCardType.BASIC_CARD_V1 -> BasicCardV1(
                    LayoutInflater.from(parent.context)
                        .inflate(contentId, parent, false)
                )
                else -> null
            } as VH
        } ?: {
            BasicCardV1(
                LayoutInflater.from(parent.context)
                    .inflate(BasicCardType.BASIC_CARD_V1.contentId, parent, false)
            )
        } as VH
    }
}