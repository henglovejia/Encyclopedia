package study.examples.debug.feed

import com.examples.feed.adapter.BaseCardAdapter
import com.examples.feed.repository.BaseCardRepository
import study.examples.component.fragment.BaseFragment
import study.examples.debug.feed.card.BaseDebugCard
import study.examples.debug.feed.item.BaseDebugItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class DebugCardAdapter<VH : BaseDebugCard<T>, T : BaseDebugItem>(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<VH, T>
) : BaseCardAdapter<VH, T>(fragment, cardRepository) {

}