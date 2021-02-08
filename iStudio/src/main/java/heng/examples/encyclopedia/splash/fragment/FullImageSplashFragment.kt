package heng.examples.encyclopedia.splash.fragment

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import heng.examples.encyclopedia.R
import heng.examples.encyclopedia.splash.SplashActivity
import study.examples.constant.main.MAIN_PAGE
import study.examples.constant.main.SPLASH_PAGE
import study.examples.widget.EncyTextView

/**
 * @author zhangHeng
 * @since 2021/1/18 6:07 下午
 * @email 932805400@qq.com
 */
@Route(path = SPLASH_PAGE)
class FullImageSplashFragment : BaseSplash() {
    override fun getSplashType() = FULL_IMAGE_TYPE
    lateinit var mSkipTV: EncyTextView
    override fun getLayoutId() = R.layout.activity_splash_main

    override fun afterCreateView(view: View) {
        super.afterCreateView(view)
        mSkipTV = view.findViewById<EncyTextView>(R.id.splash_skip).apply {
            setOnClickListener { (activity as? SplashActivity)?.jumpToMainPage(MAIN_PAGE) }
        }
    }

    override fun onStart() {
        super.onStart()
        startTimerTask()
    }

    override fun onCountDownTick(millisUntilFinished: Long) {
        context ?: return
        mSkipTV.text =
            String.format(
                resources.getString(R.string.skip_splash),
                (millisUntilFinished / 1000) + 1
            )
    }

    override fun onCountDownFinish() {
        (activity as? SplashActivity)?.jumpToMainPage(MAIN_PAGE)
    }
}