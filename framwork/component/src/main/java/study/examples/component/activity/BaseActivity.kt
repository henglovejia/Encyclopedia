package study.examples.component.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.log.LogImp
import study.examples.component.log.logD

/**
 * @author zhangHeng
 * @since 2021/1/18 3:18 下午
 * @email 932805400@qq.com
 * @actions 1、ARouter路由注册 2、布局文件获取
 */
abstract class BaseActivity : FragmentActivity(), LogImp {
    override fun getTAG(): String = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        "onCreate".logD(this)
        getLayoutId()?.let { setContentView(it) }
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

    open fun getLayoutId(): Int? = null
}