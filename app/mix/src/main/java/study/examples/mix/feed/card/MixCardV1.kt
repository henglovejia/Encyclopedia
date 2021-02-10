package study.examples.mix.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.component.feed.BaseCardVH
import study.examples.component.feed.EmptyCard
import study.examples.mix.feed.item.MixCardV1Item
import study.examples.mix.R

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */

class MixCardV1(itemView: View) : BaseCardVH<MixCardV1Item>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): EmptyCard {
            return EmptyCard(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.mix_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {
    }
}