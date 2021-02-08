package heng.examples.encyclopedia.splash.fragment

import android.os.CountDownTimer
import study.examples.component.fragment.BaseLogFragment

/**
 * @author zhangHeng
 * @since 2021/1/18 7:54 下午
 * @email 932805400@qq.com
 */
const val FULL_IMAGE_TYPE = "full_image"
const val HALF_IMAGE_TYPE = "half_image"

abstract class BaseSplash : BaseLogFragment() {
    var timerTask: CountDownTimer? = null
    abstract fun getSplashType(): String
    abstract fun onCountDownTick(millisUntilFinished: Long)
    abstract fun onCountDownFinish()

    protected fun startTimerTask(millisInFuture: Long = 4000L) {
        timerTask = object : CountDownTimer(millisInFuture, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                onCountDownTick(millisUntilFinished)
            }

            override fun onFinish() {
                onCountDownFinish()
            }
        }
        timerTask?.start()
    }

    protected fun stopTimerTask() {
        timerTask?.cancel()
    }
}