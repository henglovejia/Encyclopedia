package study.examples.advance.feed.card

import android.view.View
import com.examples.feed.holder.BaseCardVH
import study.examples.advance.model.item.BaseAdvanceItem

abstract class BaseAdvanceCard<T : BaseAdvanceItem>(itemView: View) : BaseCardVH<T>(itemView) {
}