package study.examples.advance.feed

import com.examples.feed.adapter.BaseCardAdapter
import com.examples.feed.item.BaseCardItem
import com.examples.feed.repository.BaseCardRepository
import com.examples.feed.holder.BaseCardVH
import study.examples.advance.feed.card.BaseAdvanceCard
import study.examples.advance.feed.item.BaseAdvanceItem
import study.examples.component.fragment.BaseFragment

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class AdvanceCardAdapter<VH : BaseAdvanceCard<T>, T : BaseAdvanceItem>(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<VH, T>
) : BaseCardAdapter<VH, T>(fragment, cardRepository) {

}