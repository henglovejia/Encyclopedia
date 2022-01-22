package study.examples.advance.model.item

import com.examples.feed.item.BaseCardItem

open class BaseAdvanceItem(
    private val title: String,
    private val uri: String,
    override var viewType: Int
) : BaseCardItem(viewType)