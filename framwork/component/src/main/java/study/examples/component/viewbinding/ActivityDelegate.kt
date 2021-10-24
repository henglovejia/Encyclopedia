package study.examples.component.viewbinding

import android.app.Activity
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import study.examples.component.ext.observerWhenDestroyed
import kotlin.properties.ReadOnlyProperty

abstract class ActivityDelegate<T : ViewBinding>(
    activity: Activity
) : ReadOnlyProperty<Activity, T> {

    protected var viewBinding: T? = null

    init {
        when (activity) {
            is ComponentActivity -> activity.lifecycle.observerWhenDestroyed { destroyed() }
            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    activity.observerWhenDestroyed { destroyed() }
                }
            }
        }

    }

    /**
     * 当继承 Activity 且 Build.VERSION.SDK_INT < Build.VERSION_CODES.Q 以下的时候，
     * 会添加一个 空白的 Fragment, 当生命周期处于 onDestroy 时销毁数据
     */
    fun addLifecycleFragment(activity: Activity) {
        if (activity is FragmentActivity || activity is AppCompatActivity) return

    }

    private fun destroyed() {
        viewBinding = null
    }
}