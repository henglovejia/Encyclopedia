package study.examples.component.viewbinding

import android.app.Activity
import androidx.viewbinding.ViewBinding
import study.examples.component.ext.inflateMethod
import kotlin.reflect.KProperty

class ActivityViewBinding<T : ViewBinding>(
    classes: Class<T>,
    activity: Activity
) : ActivityDelegate<T>(activity) {

    private var layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return viewBinding?.run {
            this
        } ?: let {
            val bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            thisRef.setContentView(bind.root)
            return bind.apply { viewBinding = this }
        }
    }

}