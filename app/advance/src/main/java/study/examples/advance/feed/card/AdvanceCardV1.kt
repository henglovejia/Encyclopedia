package study.examples.advance.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.advance.R
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.advance.feed.item.AdvanceCardV1Item

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class AdvanceCardV1(itemView: View) : BaseCardVH<AdvanceCardV1Item>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): EmptyCard {
            return EmptyCard(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.advance_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {
    }
}