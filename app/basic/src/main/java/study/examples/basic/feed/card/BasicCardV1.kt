package study.examples.basic.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.basic.R
import study.examples.basic.feed.item.BasicCardV1Item

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class BasicCardV1(itemView: View) : BaseBasicCard<BasicCardV1Item>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): BasicCardV1 {
            return BasicCardV1(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.basic_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {
    }
}