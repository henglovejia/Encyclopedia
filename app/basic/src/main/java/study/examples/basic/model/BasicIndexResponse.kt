package study.examples.basic.model

import study.examples.basic.model.card.BaseBasicItem

class BasicIndexResponse {
    var code: String? = null
    var message: String? = null
    val cards: MutableList<BaseBasicItem> = mutableListOf()
}