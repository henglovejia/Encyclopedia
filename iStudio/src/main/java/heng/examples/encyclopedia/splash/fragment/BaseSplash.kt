package heng.examples.encyclopedia.splash.fragment

import study.examples.component.fragment.BaseLogFragment

/**
 * @author zhangHeng
 * @since 2021/1/18 7:54 下午
 * @email 932805400@qq.com
 */
const val FULL_IMAGE_TYPE = "full_image"
const val HALF_IMAGE_TYPE = "half_image"

abstract class BaseSplash : BaseLogFragment() {
    abstract fun getSplashType(): String
}