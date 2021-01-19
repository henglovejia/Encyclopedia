package heng.examples.encyclopedia.splash.fragment

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.fragment.BaseFragment
import study.examples.component.handler.postDelay

/**
 * @author zhangheng
 * @since 2021/1/18 7:54 下午
 * @email 932805400@qq.com
 */
const val FULL_IMAGE_TYPE = "full_image"
const val HALF_IMAGE_TYPE = "half_image"

abstract class BaseSplash : BaseFragment() {
    abstract fun getSplashType(): String
}