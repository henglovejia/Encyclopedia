package study.examples.basic.model

import study.examples.basic.model.card.BaseBasicItem
import study.examples.network.response.BaseResponse

class BasicIndexResponse : BaseResponse() {
    val cards: MutableList<BaseBasicItem> = mutableListOf()
}