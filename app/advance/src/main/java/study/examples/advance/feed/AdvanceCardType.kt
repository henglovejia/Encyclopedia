package study.examples.advance.feed

import study.examples.advance.R
import study.examples.advance.model.item.AdvanceCardV1Item
import study.examples.advance.model.item.BaseAdvanceItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
val advanceCardTypes by lazy { enumValues<AdvanceCardType>() }

enum class AdvanceCardType(
    val viewType: Int,
    val contentId: Int,
    val cardItem: Class<out BaseAdvanceItem>
) {
    ADVANCE_CARD_V1(
        "basic_card_v1".hashCode(),
        R.layout.advance_list_item_tv,
        AdvanceCardV1Item::class.java
    )
}

fun Int.mapViewType2Enum(): AdvanceCardType? {
    return advanceCardTypes.find { it.viewType == this }
}