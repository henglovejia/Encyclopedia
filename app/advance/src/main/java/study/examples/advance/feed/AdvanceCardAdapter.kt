package study.examples.advance.feed

import study.examples.component.feed.BaseCardAdapter
import study.examples.component.feed.BaseCardItem
import study.examples.component.feed.BaseCardRepository
import study.examples.component.feed.BaseCardVH
import study.examples.component.fragment.BaseFragment

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class AdvanceCardAdapter(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<BaseCardVH<BaseCardItem>, BaseCardItem>
) : BaseCardAdapter<BaseCardVH<BaseCardItem>>(fragment, cardRepository) {

}