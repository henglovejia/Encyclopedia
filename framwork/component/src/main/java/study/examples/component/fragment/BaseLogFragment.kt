package study.examples.component.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.component.log.LogImp
import study.examples.component.log.logD

/**
 * @author zhangheng
 * @since 2021/1/20 3:55 下午
 * @email 932805400@qq.com
 * @actions 1、生命周期添加Log
 */
abstract class BaseLogFragment : BaseFragment(), LogImp {
    override fun getTAG(): String = javaClass.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logD("Fragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD("Fragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logD("Fragment onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logD("Fragment onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD("Fragment onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        logD("Fragment onStart")
    }

    override fun onResume() {
        super.onResume()
        logD("Fragment onResume")
    }

    override fun onPause() {
        super.onPause()
        logD("Fragment onPause")
    }

    override fun onStop() {
        super.onStop()
        logD("Fragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logD("Fragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logD("Fragment onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logD("Fragment onDetach")
    }
}