package study.examples.component.view

import android.view.View
import androidx.annotation.IdRes

/**
 * @author zhangheng
 * @since 2021/1/19 5:57 下午
 * @email 932805400@qq.com
 */
inline fun <reified T> View?.findViewSafely(@IdRes id: Int): T? {
    return this?.findViewById<View?>(id) as? T
}