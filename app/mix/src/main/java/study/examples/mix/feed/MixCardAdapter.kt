package study.examples.mix.feed

import com.examples.feed.adapter.BaseCardAdapter
import com.examples.feed.repository.BaseCardRepository
import study.examples.component.fragment.BaseFragment
import study.examples.mix.feed.card.BaseMixCard
import study.examples.mix.feed.item.BaseMixItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class MixCardAdapter<VH : BaseMixCard<T>, T : BaseMixItem>(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<VH, T>
) : BaseCardAdapter<VH, T>(fragment, cardRepository) {

}