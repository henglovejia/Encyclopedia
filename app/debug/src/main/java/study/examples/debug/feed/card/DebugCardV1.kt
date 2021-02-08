package study.examples.debug.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.debug.R
import study.examples.debug.feed.item.DebugCardV1Item

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */

class DebugCardV1(itemView: View) : BaseCardVH<DebugCardV1Item>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): EmptyCard {
            return EmptyCard(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.debug_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {

    }
}