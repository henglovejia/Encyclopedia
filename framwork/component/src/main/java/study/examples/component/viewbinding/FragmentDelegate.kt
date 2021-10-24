package study.examples.component.viewbinding

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import study.examples.component.ext.observerWhenDestroyed
import kotlin.properties.ReadOnlyProperty

abstract class FragmentDelegate<T : ViewBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    protected var viewBinding: T? = null

    init {
        val foreverObserver = Observer<LifecycleOwner> { viewOwner ->
            /**
             * 只能监听viewLifecycleOwnerLiveData是否为null来释放
             * 监听viewLifecycle释放viewBing不安全，它的destroy回调早于Fragment的onDestroyView回调
             * 如果在onDestroyView中有引用了ViewBinding会直接重新inflate一个无用的View
             */
            if (viewOwner == null) {
                viewBinding = null
            }
        }
        fragment.viewLifecycleOwnerLiveData.observeForever(foreverObserver)
        //remove应该也没啥卵用
        fragment.lifecycle.observerWhenDestroyed {
            fragment.viewLifecycleOwnerLiveData.removeObserver(foreverObserver)
        }
    }
}