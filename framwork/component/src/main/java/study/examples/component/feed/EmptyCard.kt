package study.examples.component.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */
class EmptyItem(viewType: Int) : BaseCardItem(viewType) {}

class EmptyCard(itemView: View) : BaseCardVH<EmptyItem>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): EmptyCard {
            return EmptyCard(LayoutInflater.from(parent.context).inflate(0, parent, false))
        }
    }

    override fun realBind() {}
}