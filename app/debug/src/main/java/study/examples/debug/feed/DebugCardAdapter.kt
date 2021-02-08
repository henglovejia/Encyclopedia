package study.examples.debug.feed

import study.examples.component.feed.BaseCardAdapter
import study.examples.component.feed.BaseCardItem
import study.examples.component.feed.BaseCardRepository
import study.examples.component.feed.BaseCardVH
import study.examples.component.fragment.BaseFragment

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */
class DebugCardAdapter(
    private val fragment: BaseFragment,
    val cardRepository: BaseCardRepository<BaseCardVH<BaseCardItem>, BaseCardItem>
) : BaseCardAdapter<BaseCardVH<BaseCardItem>>(fragment, cardRepository) {

}