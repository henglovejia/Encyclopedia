package study.examples.component.activity

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

/**
 * @author zhangHeng
 * @since 2021/1/20 4:00 下午
 * @email 932805400@qq.com
 */

inline fun <reified T> Activity?.findViewSafely(@IdRes id: Int): T? {
    return this?.findViewById<View?>(id) as? T
}