package study.examples.mix.feed.card

import android.view.View
import com.examples.feed.holder.BaseCardVH
import study.examples.mix.feed.item.BaseMixItem

open class BaseMixCard<T : BaseMixItem>(itemView: View) : BaseCardVH<T>(itemView) {
    override fun bindView() {
    }
}