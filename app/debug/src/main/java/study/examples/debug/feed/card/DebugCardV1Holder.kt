package study.examples.debug.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.feed.BaseCardVH
import study.examples.debug.R
import study.examples.debug.feed.item.DebugCardV1Item

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class DebugCardV1Holder(itemView: View) : BaseCardVH<DebugCardV1Item>(itemView) {
    private val mText: Button = itemView.findViewById(R.id.text)

    init {
        mText.setOnClickListener {
            if (data.uri.isNotBlank()) {
                ARouter.getInstance().build(data.uri).navigation()
            }
        }
    }

    companion object {
        fun createView(parent: ViewGroup): DebugCardV1Holder {
            return DebugCardV1Holder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.debug_list_item_tv, parent, false)
            )
        }
    }

    override fun realBind() {
        mText.text = data.title
    }
}