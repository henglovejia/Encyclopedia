package study.examples.mix.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.mix.feed.item.MixCardV1Item
import study.examples.mix.R

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class MixCardV1(itemView: View) : BaseMixCard<MixCardV1Item>(itemView) {
    companion object {
        fun createView(parent: ViewGroup): MixCardV1 {
            return MixCardV1(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.mix_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {
    }
}