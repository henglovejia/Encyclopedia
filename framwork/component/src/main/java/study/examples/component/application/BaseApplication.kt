package study.examples.component.application

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.drawee.backends.pipeline.Fresco
import study.examples.component.BuildConfig

/**
 * @author zhangHeng
 * @since 2021/1/18 3:38 下午
 * @email 932805400@qq.com
 * @description 初始化组件
 * 1.ARouter
 * 2.Fresco
 */
open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        Fresco.initialize(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}