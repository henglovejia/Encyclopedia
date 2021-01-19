package heng.examples.encyclopedia.splash.fragment

import android.view.View
import android.widget.Button
import heng.examples.encyclopedia.R
import heng.examples.encyclopedia.splash.SplashActivity
import study.examples.component.handler.postDelay
import study.examples.component.view.findViewSafely
import study.examples.constant.MAIN_PAGE

/**
 * @author zhangheng
 * @since 2021/1/19 7:06 下午
 * @email 932805400@qq.com
 */
class HalfImageSplashFragment : BaseSplash() {
    override fun getSplashType() = HALF_IMAGE_TYPE

    override fun getLayoutId() = R.layout.study_examples_activity_splash

    override fun afterCreateView(view: View) {
        super.afterCreateView(view)
        view.findViewSafely<Button>(R.id.splash_skip)?.setOnClickListener {
            (activity as? SplashActivity)?.jumpToMainPage(MAIN_PAGE)
        }
    }

    override fun onStart() {
        super.onStart()
        Runnable {
            (activity as? SplashActivity)?.jumpToMainPage(MAIN_PAGE)
        }.postDelay(4000L)
    }
}