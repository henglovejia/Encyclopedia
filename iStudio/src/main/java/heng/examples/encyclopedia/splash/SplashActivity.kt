package heng.examples.encyclopedia.splash

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import heng.examples.encyclopedia.splash.fragment.FULL_IMAGE_TYPE
import heng.examples.encyclopedia.splash.manager.SplashManager
import study.examples.component.activity.BaseLogActivity

/**
 * @author zhangHeng
 * @since 2021/1/19 6:50 下午
 * @email 932805400@qq.com
 */
class SplashActivity : BaseLogActivity() {
    private var hasJumped = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, SplashManager.factory(FULL_IMAGE_TYPE), getTAG())
            .commitAllowingStateLoss()
    }

    fun jumpToMainPage(mainRouter: String) {
        if (!hasJumped) {
            ARouter.getInstance().build(mainRouter).navigation(this, object : NavCallback() {
                override fun onArrival(postcard: Postcard?) {
                    this@SplashActivity.finish()
                }
            })
            hasJumped = true
        }
    }
}