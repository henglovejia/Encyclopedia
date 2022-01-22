package study.examples.advance.model.item

import study.examples.advance.feed.AdvanceCardType

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class AdvanceCardV1Item(
    val title: String,
    val uri: String
) : BaseAdvanceItem(title, uri, AdvanceCardType.ADVANCE_CARD_V1.viewType)