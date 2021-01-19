package study.examples.component.handler

/**
 * @author zhangheng
 * @since 2021/1/19 2:36 下午
 * @email 932805400@qq.com
 */

fun Runnable.post() {
    postDelay()
}

fun Runnable.postDelay(delayTime: Long = 0) {
    HandlerManager.getHandler().postDelayed(this, delayTime)
}