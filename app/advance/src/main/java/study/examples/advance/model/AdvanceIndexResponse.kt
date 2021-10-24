package study.examples.advance.model

import study.examples.advance.model.item.BaseAdvanceItem
import study.examples.network.response.BaseResponse

class AdvanceIndexResponse : BaseResponse() {
    val cards: List<BaseAdvanceItem> = mutableListOf()
}