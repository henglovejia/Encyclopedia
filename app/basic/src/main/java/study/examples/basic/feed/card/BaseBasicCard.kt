package study.examples.basic.feed.card

import android.view.View
import com.examples.feed.holder.BaseCardVH
import study.examples.basic.model.card.BaseBasicItem

abstract class BaseBasicCard<T : BaseBasicItem>(itemView: View) : BaseCardVH<T>(itemView)