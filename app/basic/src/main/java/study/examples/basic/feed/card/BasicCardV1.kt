package study.examples.basic.feed.card

import android.view.View
import android.widget.Button
import study.examples.basic.R
import study.examples.basic.model.card.BasicCardV1Item
import study.examples.router.RouterManager

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class BasicCardV1(itemView: View) : BaseBasicCard<BasicCardV1Item>(itemView) {
    private val mTitle: Button = itemView.findViewById(R.id.title)

    init {
        mTitle.setOnClickListener {
            RouterManager.routerTo(data.uri, fragment?.activity)
        }
    }

    override fun realBind() {
        mTitle.text = data.title
    }
}