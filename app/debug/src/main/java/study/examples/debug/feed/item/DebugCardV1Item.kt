package study.examples.debug.feed.item

import androidx.annotation.Keep
import study.examples.debug.feed.DEBUG_CARD_V1

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
@Keep
class DebugCardV1Item(val title: String, val uri: String) : BaseDebugItem(DEBUG_CARD_V1) {
}