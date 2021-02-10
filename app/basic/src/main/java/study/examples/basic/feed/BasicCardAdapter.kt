package study.examples.basic.feed

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
class BasicCardAdapter(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<BaseCardVH<BaseCardItem>, BaseCardItem>
) : BaseCardAdapter<BaseCardVH<BaseCardItem>>(fragment, cardRepository) {

}