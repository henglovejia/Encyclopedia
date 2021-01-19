package study.examples.component.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.ELog.LogImp
import study.examples.component.ELog.logD

/**
 * @author Alpha
 * @since 2021/1/18 3:19 下午
 * @email zhangheng@bilibili.com
 */
abstract class BaseFragment : Fragment(), LogImp {
    override fun getTAG(): String = javaClass.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        "Fragment onAttach".logD(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        "Fragment onCreate".logD(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        "Fragment onCreateView".logD(this)
        beforeCreateView()
        return inflater.inflate(getLayoutId(), container, false).apply {
            afterCreateView(this)
        }
    }

    open fun beforeCreateView() {}
    abstract fun getLayoutId(): Int
    open fun afterCreateView(view: View) {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        "Fragment onActivityCreated".logD(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        "Fragment onViewCreated".logD(this)
    }

    override fun onStart() {
        super.onStart()
        "Fragment onStart".logD(this)
    }

    override fun onResume() {
        super.onResume()
        "Fragment onResume".logD(this)
    }

    override fun onPause() {
        super.onPause()
        "Fragment onPause".logD(this)
    }

    override fun onStop() {
        super.onStop()
        "Fragment onStop".logD(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        "Fragment onDestroyView".logD(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        "Fragment onDestroy".logD(this)
    }

    override fun onDetach() {
        super.onDetach()
        "Fragment onDetach".logD(this)
    }
}