package study.examples.basic.feed

import study.examples.basic.R
import study.examples.basic.model.card.BaseBasicItem
import study.examples.basic.model.card.BasicCardV1Item
import study.examples.basic.model.card.ExpandableCardItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
val basicCardTypes by lazy { enumValues<BasicCardType>() }

enum class BasicCardType(
    val viewType: Int,
    val contentId: Int,
    val cardItem: Class<out BaseBasicItem>
) {
    BASIC_CARD_V1(
        "basic_card_v1".hashCode(),
        R.layout.basic_list_item_tv,
        BasicCardV1Item::class.java
    ),
    EXPANDABLE_CARD_V1(
        "expandable_card_v1".hashCode(),
        R.layout.basic_list_item_tv,
        ExpandableCardItem::class.java
    )
}

fun Int.mapViewType2Enum(): BasicCardType? {
    return basicCardTypes.find { it.viewType == this }
}