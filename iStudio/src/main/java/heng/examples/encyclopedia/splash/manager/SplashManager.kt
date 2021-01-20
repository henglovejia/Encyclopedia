package heng.examples.encyclopedia.splash.manager

import heng.examples.encyclopedia.splash.fragment.BaseSplash
import heng.examples.encyclopedia.splash.fragment.FULL_IMAGE_TYPE
import heng.examples.encyclopedia.splash.fragment.FullImageSplashFragment
import heng.examples.encyclopedia.splash.fragment.HALF_IMAGE_TYPE
import heng.examples.encyclopedia.splash.fragment.HalfImageSplashFragment


/**
 * @author zhangHeng
 * @since 2021/1/19 7:00 下午
 * @email 932805400@qq.com
 */
object SplashManager {
    @JvmStatic
    fun factory(type: String?): BaseSplash {
        return when (type) {
            FULL_IMAGE_TYPE -> FullImageSplashFragment()
            HALF_IMAGE_TYPE -> HalfImageSplashFragment()
            else -> FullImageSplashFragment()
        }
    }
}