package study.examples.debug.feed.card

import android.view.View
import com.examples.feed.holder.BaseCardVH
import study.examples.debug.feed.item.BaseDebugItem

abstract class BaseDebugCard<T : BaseDebugItem>(itemView: View) : BaseCardVH<T>(itemView)