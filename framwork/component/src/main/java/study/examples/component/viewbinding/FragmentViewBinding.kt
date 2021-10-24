package study.examples.component.viewbinding

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import study.examples.component.ext.bindMethod
import study.examples.component.ext.inflateMethod
import kotlin.reflect.KProperty

class FragmentViewBinding<T : ViewBinding>(
    classes: Class<T>,
    fragment: Fragment
) : FragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()
    private val bindView = classes.bindMethod()

    override operator fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding ?: let {
            if (thisRef.view == null) {
                // 这里为了兼容在 navigation 中使用 Fragment
                layoutInflater.invoke(null, thisRef.layoutInflater) as T
            } else {
                bindView.invoke(null, thisRef.view) as T
            }.apply { viewBinding = this }
        }
    }
}