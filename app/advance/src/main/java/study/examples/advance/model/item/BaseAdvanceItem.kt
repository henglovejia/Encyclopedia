package study.examples.advance.model.item

import com.alibaba.fastjson.annotation.JSONField
import com.examples.feed.item.BaseCardItem

abstract class BaseAdvanceItem : BaseCardItem() {
    @field:JSONField(name = "card_type")
    var cardType: String? = null
    @field:JSONField(name = "title")
    var title: String? = null
    @field:JSONField(name = "uri")
    var uri: String? = null
}