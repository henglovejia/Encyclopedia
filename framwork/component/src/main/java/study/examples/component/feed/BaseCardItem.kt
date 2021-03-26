package study.examples.component.feed

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
abstract class BaseCardItem(type: Int = 0) {
    open val viewType: Int = type
}