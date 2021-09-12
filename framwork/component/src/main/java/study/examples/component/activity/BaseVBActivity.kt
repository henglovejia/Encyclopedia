package study.examples.component.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.log.LogImp
import study.examples.component.log.logD

abstract class BaseVBActivity<VB : ViewBinding> : FragmentActivity(), LogImp {
    override fun getTAG(): String = this::class.java.name

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        "onCreate".logD(this)
        binding = getViewBinding()
        setContentView(binding.root)
        ARouter.getInstance().inject(this)
    }

    override fun onStart() {
        super.onStart()
        "onStart".logD(this)
    }

    override fun onResume() {
        super.onResume()
        "onResume".logD(this)
    }

    override fun onPause() {
        super.onPause()
        "onPause".logD(this)
    }

    override fun onStop() {
        super.onStop()
        "onStop".logD(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy".logD(this)
    }

    override fun onRestart() {
        super.onRestart()
        "onRestart".logD(this)
    }

    protected abstract fun getViewBinding(): VB
}