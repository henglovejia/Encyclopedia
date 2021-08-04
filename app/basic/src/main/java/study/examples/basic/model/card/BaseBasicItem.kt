package study.examples.basic.model.card

import com.alibaba.fastjson.annotation.JSONField
import com.examples.feed.item.BaseCardItem

abstract class BaseBasicItem : BaseCardItem() {
    @field:JSONField(name = "card_type")
    var cardType: String? = null
    @field:JSONField(name = "title")
    var title: String? = null
}