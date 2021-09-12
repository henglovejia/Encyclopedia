package heng.examples.encyclopedia.splash.fragment

import android.view.View
import heng.examples.encyclopedia.R
import heng.examples.encyclopedia.splash.SplashActivity
import study.examples.constant.main.MAIN_PAGE
import study.examples.widget.EncyTextView

/**
 * @author zhangHeng
 * @since 2021/1/19 7:06 下午
 * @email 932805400@qq.com
 */
class HalfImageSplashFragment : BaseSplash() {
    override fun getSplashType() = HALF_IMAGE_TYPE
    lateinit var mSkipTV: EncyTextView
    override fun getLayoutId() = R.layout.activity_splash_main

    override fun afterCreateView(view: View) {
        mSkipTV = view.findViewById<EncyTextView>(R.id.splash_skip).apply {
            setOnClickListener {
                stopTimerTask()
                (activity as? SplashActivity)?.jumpToMainPage(MAIN_PAGE)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        startTimerTask()
    }

    override fun onCountDownTick(millisUntilFinished: Long) {
        mSkipTV.text =
            String.format(resources.getString(R.string.skip_splash), millisUntilFinished / 1000 + 1)
    }

    override fun onCountDownFinish() {
        (activity as? SplashActivity)?.jumpToMainPage(MAIN_PAGE)
    }
}