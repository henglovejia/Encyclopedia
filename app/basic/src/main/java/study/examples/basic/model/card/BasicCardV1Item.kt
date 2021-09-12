package study.examples.basic.model.card

import com.alibaba.fastjson.annotation.JSONField

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class BasicCardV1Item : BaseBasicItem() {
    @field:JSONField(name = "childs")
    var children: List<BasicCardV1ChildItem>? = null

    val childCount: Int
        get() = children?.size ?: 0

    inner class BasicCardV1ChildItem : BaseBasicItem()
}