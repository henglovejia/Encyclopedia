package heng.examples.encyclopedia.splash.manager

import heng.examples.encyclopedia.splash.fragment.*

/**
 * @author zhangheng
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