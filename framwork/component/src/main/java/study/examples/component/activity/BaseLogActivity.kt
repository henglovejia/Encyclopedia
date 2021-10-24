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
        logD("Activity onCreate")
    }

    override fun onStart() {
        super.onStart()
        logD("Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        logD("Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        logD("Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        logD("Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logD("Activity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logD("Activity onRestart")
    }
}