package study.examples.component.handler

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Process.THREAD_PRIORITY_DEFAULT
import android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE
import androidx.annotation.IntRange

/**
 * @author zhangheng
 * @since 2021/1/19 11:54 上午
 * @email 932805400@qq.com
 */
object HandlerManager {
    /**
     * UI线程 Handler
     */
    const val UI_THREAD = 0

    /**
     * 后台线程 Handler
     */
    const val BACKGROUND_THREAD = 1

    /**
     * IO线程 Handler
     */
    const val IO_THREAD = 2

    /**
     * 最多线程数
     */
    private const val MAX_THREADS = 3L

    private val THREAD_NAME_LIST: List<String> = listOf(
        "thread_ui",
        "background_thread",
        "io_thread"
    )

    /**
     * Handler 维护数组
     */
    private val THREAD_LIST = arrayOfNulls<Handler>(MAX_THREADS.toInt())

    /**
     * @param threadIndex Handler索引 默认UI线程
     */
    @JvmStatic
    fun getHandler(@IntRange(from = 0, to = MAX_THREADS) threadIndex: Int = UI_THREAD): Handler {
        if (THREAD_LIST[threadIndex] == null) {
            THREAD_LIST[threadIndex] = generateHandler(threadIndex)
        }
        return THREAD_LIST[threadIndex]!!
    }

    @Synchronized
    private fun generateHandler(threadIndex: Int): Handler {
        return Handler(
            if (threadIndex == UI_THREAD) {
                Looper.getMainLooper()
            } else {
                HandlerThread(
                    THREAD_NAME_LIST[threadIndex],
                    THREAD_PRIORITY_DEFAULT + THREAD_PRIORITY_LESS_FAVORABLE
                ).run {
                    start()
                    looper
                }
            })
    }
}