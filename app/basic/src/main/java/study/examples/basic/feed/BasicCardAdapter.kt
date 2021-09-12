package study.examples.basic.feed

import com.examples.feed.adapter.BaseCardAdapter
import com.examples.feed.repository.BaseCardRepository
import study.examples.basic.feed.card.BaseBasicCard
import study.examples.basic.model.card.BaseBasicItem
import study.examples.component.fragment.BaseFragment

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class BasicCardAdapter<VH : BaseBasicCard<T>, T : BaseBasicItem>(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<VH, T>
) : BaseCardAdapter<VH, T>(fragment, cardRepository) {

}