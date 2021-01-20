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
        "Fragment onAttach".logD(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        "Fragment onCreate".logD(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        "Fragment onCreateView".logD(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

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