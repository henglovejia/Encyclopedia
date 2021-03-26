package study.examples.basic.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.basic.R
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.basic.feed.item.BasicCardV1Item

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class BasicCardV1(itemView: View) : BaseCardVH<BasicCardV1Item>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): EmptyCard {
            return EmptyCard(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.basic_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {
    }
}