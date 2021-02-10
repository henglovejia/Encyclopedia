package study.examples.component.feed

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */
abstract class BaseCardItem(type: Int = 0) {
    open val viewType: Int = type
}