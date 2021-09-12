package study.examples.component.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.log.LogImp
import study.examples.component.log.logD

abstract class BaseVBFragment<VB : ViewBinding> : Fragment(), LogImp {
    protected lateinit var binding: VB
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        "Fragment onCreateView".logD(this)
        binding = getViewBinding(inflater, container)
        return binding.root
    }

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

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
}