package study.examples.component.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.ELog.logD
import study.examples.component.ELog.LogImp

/**
 * @author Alpha
 * @since 2021/1/18 3:18 下午
 * @email zhangheng@bilibili.com
 */
abstract class BaseActivity : FragmentActivity(), LogImp {
    override fun getTAG(): String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let { setContentView(it) }
        ARouter.getInstance().inject(this)
        "Activity onCreate".logD(this)
    }

    override fun onStart() {
        super.onStart()
        "Activity onStart".logD(this)
    }

    override fun onResume() {
        super.onResume()
        "Activity onResume".logD(this)
    }

    override fun onPause() {
        super.onPause()
        "Activity onPause".logD(this)
    }

    override fun onStop() {
        super.onStop()
        "Activity onStop".logD(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        "Activity onDestroy".logD(this)
    }

    override fun onRestart() {
        super.onRestart()
        "Activity onRestart".logD(this)
    }

    open fun getLayoutId(): Int? = null
}