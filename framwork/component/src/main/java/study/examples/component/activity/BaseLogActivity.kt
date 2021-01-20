package study.examples.component.activity

import android.os.Bundle
import study.examples.component.log.LogImp
import study.examples.component.log.logD

/**
 * @author zhangHeng
 * @since 2021/1/20 3:48 下午
 * @email 932805400@qq.com
 * @actions 1、生命周期添加Log
 */
abstract class BaseLogActivity : BaseActivity(), LogImp {
    override fun getTAG(): String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}